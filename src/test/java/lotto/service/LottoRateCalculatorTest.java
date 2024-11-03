package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.constant.WinningCondition;
import lotto.dto.MatchingCountResult;
import org.junit.jupiter.api.Test;

class LottoRateCalculatorTest {
    @Test
    void 수익률을_계산한다() {
        MatchingCountResult matchingCountResult = new MatchingCountResult(WinningCondition.MATCH_3);
        matchingCountResult.addCount();
        List<MatchingCountResult> matchingCountResults = List.of(matchingCountResult);
        int amount = 8000;
        double rate = LottoRateCalculator.calculateReturnOfRate(amount, matchingCountResults);
        assertEquals(62.5, rate);
    }
}