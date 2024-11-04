package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotificationMessageTest {

    @Test
    @DisplayName("소수점 이하 한 자리에서 반올림된 수익률 표시")
    void testProfitRateMessageForSmallValue() {
        String formattedMessage = NotificationMessage.PROFIT_RATE.format(51.567);
        assertEquals("총 수익률은 51.6%입니다.", formattedMessage);
    }

    @Test
    @DisplayName("천 단위 구분자가 있는 정수 수익률 표시")
    void testProfitRateMessageForThousandSeparatorWholeNumber() {
        String formattedMessage = NotificationMessage.PROFIT_RATE.format(1000.0);
        assertEquals("총 수익률은 1,000.0%입니다.", formattedMessage);
    }

    @Test
    @DisplayName("백만 단위 구분자와 소수점 이하 한 자리로 표시된 큰 수익률 표시")
    void testProfitRateMessageForMillionSeparatorWithDecimal() {
        String formattedMessage = NotificationMessage.PROFIT_RATE.format(1234567.89);
        assertEquals("총 수익률은 1,234,567.9%입니다.", formattedMessage);
    }
}
