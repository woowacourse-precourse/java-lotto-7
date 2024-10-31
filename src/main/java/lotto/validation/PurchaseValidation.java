package lotto.validation;

public final class PurchaseValidation {
    public static int purchaseValidation(String inputValue) throws IllegalArgumentException {
        InputValidation.isNotBlank(inputValue);
        return 0;
    }
}
