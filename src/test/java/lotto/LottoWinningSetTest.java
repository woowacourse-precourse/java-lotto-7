package lotto;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoWinningSetTest {
    @Test
    void 당첨_번호와_일치하는_로또_수_계산() {
        //given
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(Arrays.asList(1, 11, 12, 13, 14, 15));
        int bonusNumber = 7;
        LottoWinningSet lottoWinningSet = new LottoWinningSet(winningNumber, bonusNumber);

        //when
        int matchingWinningNumber = lottoWinningSet.countMatchingNumbers(lotto);

        //then
        Assertions.assertThat(matchingWinningNumber).isEqualTo(1);
    }

    @Test
    void 로또에_일치하는_보너스_뻔호가_있는지_계산() {
        //given
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(Arrays.asList(7, 11, 12, 13, 14, 15));
        int bonusNumber = 7;
        LottoWinningSet lottoWinningSet = new LottoWinningSet(winningNumber, bonusNumber);

        //when
        boolean result = lottoWinningSet.hasMatchingBonusNumber(lotto);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }

}