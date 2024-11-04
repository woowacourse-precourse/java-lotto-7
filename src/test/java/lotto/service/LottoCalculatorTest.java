package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.WinnerResult;
import lotto.domain.Winners;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    private WinnerResult winnerResult;

    @BeforeEach
    void setUp() {
        Winners threeMatchedWinners = Winners.THREE_MATCHED;
        Winners fiveMatchedWinners = Winners.FIVE_MATCHED;

        winnerResult = new WinnerResult();

        winnerResult.addMatchedAmount(threeMatchedWinners);
        winnerResult.addMatchedAmount(threeMatchedWinners);
        winnerResult.addMatchedAmount(fiveMatchedWinners);
    }

    @Test
    @DisplayName("총 당첨금을 구할 수 있습니다.")
    void 총_당첨금을_구할_수_있습니다() {
        //given

        //when
        int sum = LottoCalculator.sumAmount(winnerResult);

        //then
        assertEquals(1510000, sum);
    }

    @Test
    @DisplayName("수익률을 구할 수 있습니다.")
    void 수익률을_구할_수_있습니다() {
        //given
        //when
        double finalRate = LottoCalculator.calculateFinalRate(winnerResult, 14000000);

        //then
        assertEquals(10.79, finalRate);
    }

}