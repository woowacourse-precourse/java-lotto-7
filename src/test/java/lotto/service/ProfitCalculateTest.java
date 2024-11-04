package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ProfitCalculate 클래스 테스트")
public class ProfitCalculateTest {

    @Test
    void 수익률_계산_테스트() {
        //given
        Map<Prize, Integer> prizeCounts = new HashMap<>();
        prizeCounts.put(Prize.FIRST, 1);
        prizeCounts.put(Prize.SECOND, 0);
        prizeCounts.put(Prize.THIRD, 0);
        prizeCounts.put(Prize.FOURTH, 0);
        prizeCounts.put(Prize.FIFTH, 0);

        int purchasePrice = 10000;
        BigDecimal expectedProfit = new BigDecimal("200000.0");
        //when
        BigDecimal profit = ProfitCalculate.calculateProfit(purchasePrice, prizeCounts);

        //then
        assertEquals(profit, expectedProfit);
    }

}
