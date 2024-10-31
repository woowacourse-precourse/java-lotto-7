package lotto.validation;

public final class PurchaseValidation {
    public static int purchaseAmountValidation(String inputValue) throws IllegalArgumentException {
        InputValidation.isNotBlank(inputValue);
        int number = InputValidation.parseValidateNumber(inputValue);
        return number;
    }
}
