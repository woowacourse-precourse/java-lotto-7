package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {

    @Test
    void passValidatePurchaseAmount() {
        // given
        Integer purchaseAmount = 1000;
        // when
        Validate validate = new Validate();
        // then
        assertDoesNotThrow(() -> validate.validatePurchaseAmount(purchaseAmount));
    }

    @Test
    void failValidatePurchaseAmountUnder1000() {
        // given
        Integer purchaseAmount = 999;
        // when
        Validate validate = new Validate();
        // then
        assertThrows(IllegalArgumentException.class, () -> validate.validatePurchaseAmount(purchaseAmount));
    }

    @Test
    void failValidatePurchaseAmountNot1000Unit() {
        // given
        Integer purchaseAmount = 1500;
        // when
        Validate validate = new Validate();
        // then
        assertThrows(IllegalArgumentException.class, () -> validate.validatePurchaseAmount(purchaseAmount));
    }

    @Test
    void passValidateNumber() {
        // given
        Integer number = 1;
        // when
        Validate validate = new Validate();
        // then
        assertDoesNotThrow(() -> validate.validateNumber(number));
    }

    @Test
    void failValidateNumberUnder1() {
        // given
        Integer number = 0;
        // when
        Validate validate = new Validate();
        // then
        assertThrows(IllegalArgumentException.class, () -> validate.validateNumber(number));
    }
}