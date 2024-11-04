package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.Prize;
import lotto.domain.PublishCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ProfitCalculate 클래스 테스트")
public class ProfitCalculateTest {

    private ProfitCalculate profitCalculate;
    private PublishCount publishCount;

    @BeforeEach
    void setUp() {
        ProfitCalculate = new ProfitCalculate();
        publishCount = PublishCount.getInstance(5);
    }

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

        //when
        BigDecimal profit = ProfitCalculate.calculatePrice(purchasePrice, prizeCounts);

        //then
        assertEquals(profit, 200000);
    }

}
