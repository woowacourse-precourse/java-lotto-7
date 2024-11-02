package lotto.model;

import lotto.constants.PrizeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

class CalculateResultTest {

    @Test
    @DisplayName("로또 당첨 번호와 사용자의 번호를 비교하여 매칭 결과를 반환해야 한다.")
    void calculateStatistics_shouldReturnCorrectMatchingResults() {
        // Given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<List<Integer>> userLottoNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6), // 1등 (6개 일치)
                Arrays.asList(1, 2, 3, 4, 5, 7), // 2등 (5개 일치 + 보너스 볼)
                Arrays.asList(1, 2, 3, 4, 8, 10), // 4등 (4개 일치)
                Arrays.asList(1, 2, 3, 4, 8, 10), // 4등 (4개 일치)
                Arrays.asList(1, 2, 3, 8, 9, 10), // 5등 (3개 일치)
                Arrays.asList(1, 2, 8, 9, 10, 11) // 꽝
        );

        LottoStatisticsCalculator calculateResult = new LottoStatisticsCalculator();

        int[] results = calculateResult.calculateStatistics(winningNumbers, bonusNumber, userLottoNumbers);

        assertThat(results[PrizeType.PLACE_OF_1ST.ordinal()]).isEqualTo(1); // 1등
        assertThat(results[PrizeType.PLACE_OF_2ST.ordinal()]).isEqualTo(1); // 2등
        assertThat(results[PrizeType.PLACE_OF_3ST.ordinal()]).isEqualTo(0); // 3등
        assertThat(results[PrizeType.PLACE_OF_4ST.ordinal()]).isEqualTo(2); // 4등
        assertThat(results[PrizeType.PLACE_OF_5ST.ordinal()]).isEqualTo(1); // 5등
    }
}
