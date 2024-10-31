package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {
    @Test
    @DisplayName("구입 금액 단위 테스트")
    public void validateUnitTest() {
        String amount = "1234";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseAmount(amount);
        });
        assertEquals(exception.getMessage(), ErrorMessage.UNIT_DIVISIBLE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("구입 금액 최대 금액 초과 테스트")
    public void validateMax() {
        String amount = "100001000";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseAmount(amount);
        });
        assertEquals(exception.getMessage(), ErrorMessage.PURCHASE_AMOUNT_MAX_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("구입 금액에 따른 로또 구매 개수 테스트")
    public void getNumberOfLottoTest() {
        //given
        String amount = "8000";
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        //when
        int numberOfLotto = purchaseAmount.getNumberOfLotto();
        //then
        assertEquals(8, numberOfLotto);
    }
}