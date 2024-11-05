package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 로또_번호와_당첨_번호_비교_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        //when
        int matchCount = winningLotto.countMatchingNumbers(lotto);

        //then
        assertThat(matchCount).isEqualTo(5);
    }

    @Test
    void 보너스_번호와_로또_번호_중복_테스트() {
        //given
        Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        int bonusNumber = 7;

        //when & then
        assertThatThrownBy(() -> winningLotto.validateDuplicateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }
}