package lotto.exception;

public class ValidateValues {

    public static int purchaseAmount(String inputPurchaseAmount) {
        if(InputValidation.NOT_BLANK.validate(inputPurchaseAmount)
            && InputValidation.NOT_NUMBER.validate(inputPurchaseAmount)
            && InputValidation.NOT_DIVISIBLE_BY_1000.validate(inputPurchaseAmount)) {
            return Integer.parseInt(inputPurchaseAmount);
        }
        return 0;
    }

    public static boolean winningNumber(String winningNumber) {
        if(InputValidation.NOT_NUMBER.validate(winningNumber)
            && InputValidation.NOT_INTEGER.validate(winningNumber)
            && InputValidation.NOT_IN_RANGE_1_TO_45.validate(winningNumber)) {
            return true;
        }
        return false;
    }

}
