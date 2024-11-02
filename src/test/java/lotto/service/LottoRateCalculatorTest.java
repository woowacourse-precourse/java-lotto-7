package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.constant.WinningCondition;
import lotto.dto.MatchingCountResult;
import org.junit.jupiter.api.Test;

class LottoRateCalculatorTest {
    /*
    수익률=(총수익 / 총 투자금액) x 100
 )
     */
    @Test
    void 수익률을_계산한다() {
        MatchingCountResult matchingCountResult1 = new MatchingCountResult(WinningCondition.MATCH_3, 1);
        List<MatchingCountResult> matchingCountResults = List.of(matchingCountResult1);
        int amount = 8000;
        double rate = LottoRateCalculator.calculateReturnOfRate(8000, matchingCountResults);
        assertEquals(62.5, rate);
    }
}