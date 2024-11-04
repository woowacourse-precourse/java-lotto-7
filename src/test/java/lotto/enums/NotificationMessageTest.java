package lotto.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NotificationMessageTest {

    @Test
    void testProfitRateMessage() {
        // Test rounding to one decimal place
        String formattedMessage = NotificationMessage.PROFIT_RATE.format(51.567);
        assertEquals("총 수익률은 51.6%입니다.", formattedMessage);

        formattedMessage = NotificationMessage.PROFIT_RATE.format(1000.0);
        assertEquals("총 수익률은 1,000.0%입니다.", formattedMessage);

        formattedMessage = NotificationMessage.PROFIT_RATE.format(1234567.89);
        assertEquals("총 수익률은 1,234,567.9%입니다.", formattedMessage);
    }
    
}
