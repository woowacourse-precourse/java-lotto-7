package lotto.system.formater.profit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProfitRateFormatterTest {

    @Test
    void formatAsMessage() {

        // given
        double profitRate = 0.5;

        // when
        String actual = ProfitRateFormatter.formatAsMessage(profitRate);

        // then
        assertEquals("총 수익률은 0.5%입니다.", actual);
    }
}