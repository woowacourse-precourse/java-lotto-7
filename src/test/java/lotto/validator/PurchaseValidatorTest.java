package lotto.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseValidatorTest {
    private PurchaseValidator purchaseValidator = new PurchaseValidator();

    @Test
    @DisplayName("구매 금액에 대한 예외 테스트")
    void testValidatePurchaseAmount() {

        String input1 = "abcd";
        String input2 = "";
        String input3 = "1500";
        String input4 = "-1500";
        String input5 = "ab1000";
        String input6 = "0";
        String input7 = "1000";
        String input8 = "   1000";

        boolean result1 = purchaseValidator.validatePurchaseAmount(input1);
        boolean result2 = purchaseValidator.validatePurchaseAmount(input2);
        boolean result3 = purchaseValidator.validatePurchaseAmount(input3);
        boolean result4 = purchaseValidator.validatePurchaseAmount(input4);
        boolean result5 = purchaseValidator.validatePurchaseAmount(input5);
        boolean result6 = purchaseValidator.validatePurchaseAmount(input6);
        boolean result7 = purchaseValidator.validatePurchaseAmount(input7);
        boolean result8 = purchaseValidator.validatePurchaseAmount(input8);

        Assertions.assertFalse(result1);
        Assertions.assertFalse(result2);
        Assertions.assertFalse(result3);
        Assertions.assertFalse(result4);
        Assertions.assertFalse(result5);
        Assertions.assertFalse(result6);
        Assertions.assertTrue(result7);
        Assertions.assertTrue(result8);
    }
}