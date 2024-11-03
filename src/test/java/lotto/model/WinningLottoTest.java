package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    void 로또_번호를_추첨한다() {
        assertSimpleTest(() -> {
            Lotto drawedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(7);
            WinningLotto winningLotto = new WinningLotto(drawedLotto, bonusNumber);
            assertThat(winningLotto.getLotto()).isEqualTo(drawedLotto);
            assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
        });
    }

    @Test
    void 보너스_번호를_포함한_7개의_당첨_번호_중_중복된_번호가_있으면_예외를_발생한다() {
        assertThatThrownBy(() -> {
            Lotto drawedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(6);
            new WinningLotto(drawedLotto, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_1등에_당첨된다() {
        assertSimpleTest(() -> {
            Lotto boughtLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto drawedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(8);
            WinningLotto winningLotto = new WinningLotto(drawedLotto, bonusNumber);
            assertThat(winningLotto.calculateRank(boughtLotto)).isEqualTo(Rank._1TH);
        });
    }

    @Test
    void 로또_2등에_당첨된다() {
        assertSimpleTest(() -> {
            Lotto boughtLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto drawedLotto = new Lotto(List.of(1, 2, 3, 45, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(4);
            WinningLotto winningLotto = new WinningLotto(drawedLotto, bonusNumber);
            assertThat(winningLotto.calculateRank(boughtLotto)).isEqualTo(Rank._2TH);
        });
    }

    @Test
    void 로또_3등에_당첨된다() {
        assertSimpleTest(() -> {
            Lotto boughtLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto drawedLotto = new Lotto(List.of(1, 2, 3, 45, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(42);
            WinningLotto winningLotto = new WinningLotto(drawedLotto, bonusNumber);
            assertThat(winningLotto.calculateRank(boughtLotto)).isEqualTo(Rank._3TH);
        });
    }

    @Test
    void 로또_4등에_당첨된다() {
        assertSimpleTest(() -> {
            Lotto boughtLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto drawedLotto = new Lotto(List.of(1, 2, 32, 45, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(31);
            WinningLotto winningLotto = new WinningLotto(drawedLotto, bonusNumber);
            assertThat(winningLotto.calculateRank(boughtLotto)).isEqualTo(Rank._4TH);
        });
    }

    @Test
    void 로또_5등에_당첨된다() {
        assertSimpleTest(() -> {
            Lotto boughtLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto drawedLotto = new Lotto(List.of(40, 2, 32, 45, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(31);
            WinningLotto winningLotto = new WinningLotto(drawedLotto, bonusNumber);
            assertThat(winningLotto.calculateRank(boughtLotto)).isEqualTo(Rank._5TH);
        });
    }
}
