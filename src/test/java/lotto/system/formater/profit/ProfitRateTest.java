package lotto.system.formater.profit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProfitRateTest {

    @Test
    void testToString() {
        // given
        ProfitRate profitRate = new ProfitRate(0.5);

        // when
        String actual = profitRate.toString();

        // then
        assertEquals("0.50%", actual);
    }

    @Test
    void profitRate() {

        // given
        ProfitRate profitRate = new ProfitRate(0.5);

        // when
        double actual = profitRate.profitRate();

        // then
        assertEquals(0.5, actual);
    }
}