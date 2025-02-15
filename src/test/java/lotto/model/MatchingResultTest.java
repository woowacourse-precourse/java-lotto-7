package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchingResultTest {

    @DisplayName("1등과 5등을 동시에 했을 때, 올바른 수익률을 계산하는 지 확인하기")
    @Test
    void givenFirstAndFifthRankInfo_whenCalculateEarningsRate_thenCorrect() {
        MatchingResult matchingResult = new MatchingResult(8);
        matchingResult.incrementsSingleMatchCount(Rank.FIRST_PRIZE);
        matchingResult.incrementsSingleMatchCount(Rank.FIFTH_PRIZE);

        double expected = 25_000_062.5;
        double result = matchingResult.calculateEarningsRate();
        Assertions.assertEquals(expected, result);
    }
}