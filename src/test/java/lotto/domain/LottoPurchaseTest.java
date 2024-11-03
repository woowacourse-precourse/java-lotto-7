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

}