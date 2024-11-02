package lotto.model.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseRequestHandlerTest {

    private final PurchaseRequestHandler purchaseRequestHandler = new PurchaseRequestHandler();

    @Test
    @DisplayName("정상적인 금액 입력 시 로또 장 수를 올바르게 반환해야 한다.")
    void shouldReturnCorrectLottoCount() {
        int count = purchaseRequestHandler.getPurchaseAmount("5000");
        assertEquals(5, count);

        count = purchaseRequestHandler.getPurchaseAmount("1000");
        assertEquals(1, count);
    }

    @Test
    @DisplayName("문자열, 공백 등의 잘못된 입력 시 예외가 발생해야 한다.")
    void shouldThrowExceptionInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            purchaseRequestHandler.getPurchaseAmount("abc");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            purchaseRequestHandler.getPurchaseAmount(" ");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            purchaseRequestHandler.getPurchaseAmount("1000a");
        });
    }

}
