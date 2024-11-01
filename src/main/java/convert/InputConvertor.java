package convert;

import valid.Validate;

public class InputConvertor {

    public String convertPurchaseAmount(String inputPurchaseAmount) {
        isNumber(inputPurchaseAmount);

        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        validatePurchaseAmount(purchaseAmount);
        return inputPurchaseAmount;
    }

    private void isNumber(String input) {
        Validate.isNumber(input);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        Validate.isPositiveNumber(purchaseAmount);
        Validate.isThousandUnit(purchaseAmount);
    }
}
