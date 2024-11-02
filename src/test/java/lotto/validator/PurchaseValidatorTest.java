package lotto.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseValidatorTest {
    private PurchaseValidator purchaseValidator = new PurchaseValidator();

    @Test
    @DisplayName("구매 금액에 대한 예외 테스트")
    void testValidatePurchaseAmount() {

        String wrongInput1 = "abcd";
        String wrongInput2 = "";
        String wrongInput3 = "1500";
        String wrongInput4 = "-1500";
        String wrongInput5 = "ab1000";
        String wrongInput6 = "0";
        String wrongInput7 = " ";

        String rightInput1 = "1000";
        String rightInput2 = "   1000";

        boolean wrongResult1 = purchaseValidator.validatePurchaseAmount(wrongInput1);
        boolean wrongResult2 = purchaseValidator.validatePurchaseAmount(wrongInput2);
        boolean wrongResult3 = purchaseValidator.validatePurchaseAmount(wrongInput3);
        boolean wrongResult4 = purchaseValidator.validatePurchaseAmount(wrongInput4);
        boolean wrongResult5 = purchaseValidator.validatePurchaseAmount(wrongInput5);
        boolean wrongResult6 = purchaseValidator.validatePurchaseAmount(wrongInput6);
        boolean wrongResult7 = purchaseValidator.validatePurchaseAmount(wrongInput7);

        boolean rightResult1 = purchaseValidator.validatePurchaseAmount(rightInput1);
        boolean rightResult2 = purchaseValidator.validatePurchaseAmount(rightInput2);

        Assertions.assertFalse(wrongResult1);
        Assertions.assertFalse(wrongResult2);
        Assertions.assertFalse(wrongResult3);
        Assertions.assertFalse(wrongResult4);
        Assertions.assertFalse(wrongResult5);
        Assertions.assertFalse(wrongResult6);
        Assertions.assertFalse(wrongResult7);

        Assertions.assertTrue(rightResult1);
        Assertions.assertTrue(rightResult2);
    }
}