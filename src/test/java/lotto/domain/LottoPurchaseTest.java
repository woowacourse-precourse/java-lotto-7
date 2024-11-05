package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class LottoPurchaseTest {
    @Test
    @DisplayName("유효한 금액 입력으로 LottoPurchase 객체 생성")
    void createLottoPurchaseWithValidAmount() {
        LottoPurchase purchase = LottoPurchase.of(5000);
        assertEquals(5000, purchase.getAmount());
        assertEquals(5, purchase.getTicketCount());
    }

    @Test
    @DisplayName("1000의 배수가 아닌 금액 입력 시 예외 발생")
    void createLottoPurchaseWithInvalidAmount() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> LottoPurchase.of(1500));
        assertEquals("금액은 1,000원으로 나누어 떨어져야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("0 이하의 금액 입력 시 예외 발생")
    void createLottoPurchaseWithZeroOrNegativeAmount() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> LottoPurchase.of(0));
        assertEquals("금액은 0일 수 없습니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> LottoPurchase.of(-100));
        assertEquals("금액은 1,000원으로 나누어 떨어져야 합니다.", exception.getMessage());
    }
}