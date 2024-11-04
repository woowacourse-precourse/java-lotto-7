package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constant.Rank;

@DisplayName("당첨 로또는")
class WinningLottoTest {

    @Test
    void 보너스_번호가_당첨_번호와_중복될_경우_예외를_반환한다() {
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.setupLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThatThrownBy(() -> winningLotto.setupBonusNumber(3))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_순위를_올바르게_계산한다() {
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);

        WinningLotto winningLotto = new WinningLotto();
        winningLotto.setupLotto(new Lotto(winningLottoNumbers));
        winningLotto.setupBonusNumber(8);
        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(winningLotto.getRank(lotto)).isEqualTo(Rank.THIRD);
    }
}
