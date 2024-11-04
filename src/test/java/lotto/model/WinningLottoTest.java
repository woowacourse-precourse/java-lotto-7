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
}
