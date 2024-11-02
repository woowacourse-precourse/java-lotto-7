package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoValidationTest {
    List<Integer> winningNumbers = List.of(1, 3, 5, 7, 9, 11);
    List<Integer> winningResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
    LottoValidation lottoValidation = new LottoValidation(winningNumbers, winningResult);

    @Test
    void 당첨통계_변경_테스트() {
        List<Integer> lottoNumber = List.of(1, 3, 5, 7, 9, 13);
        int bonusNumber = 11;

        lottoValidation.updateWinningResult(lottoNumber, bonusNumber);
        assertThat(winningResult).isEqualTo(Arrays.asList(0, 1, 0, 0, 0));
    }

    @Test
    void 당첨통계_미변경_테스트() {
        List<Integer> lottoNumber = List.of(2, 4, 6, 8, 10, 12);
        int bonusNumber = 11;

        lottoValidation.updateWinningResult(lottoNumber, bonusNumber);
        assertThat(winningResult).isEqualTo(Arrays.asList(0, 0, 0, 0, 0));
    }

    @Test
    void 수익률_계산_테스트() {
        int purchaseAmount = 8000;
        winningResult.set(4, 1);
        assertThat(lottoValidation.calculateProfitRate(purchaseAmount)).isEqualTo(62.5);
    }

}