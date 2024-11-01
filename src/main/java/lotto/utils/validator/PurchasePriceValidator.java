package lotto.utils.validator;

import static lotto.exception.ErrorMessages.BEYOND_LIMIT;

public class PurchasePriceValidator implements Validator<String> {
    private final int LOTTO_PRICE = 1000;
    private final int PURCHASE_LIMIT = 100000;
    private final Validator<String> positiveIntValidator;

    public PurchasePriceValidator(Validator<String> positiveIntValidator) {
        this.positiveIntValidator = positiveIntValidator;
    }

    @Override
    public void validate(String rawPurchasePrice) {
        positiveIntValidator.validate(rawPurchasePrice);

        int purchasePrice = Integer.parseInt(rawPurchasePrice);
        validateDividedByLottoPrice(purchasePrice);
        validateNotBeyondPurchaseLimit(purchasePrice);
    }

    private void validateDividedByLottoPrice (int purchasePrice) {
        if (purchasePrice % LOTTO_PRICE != 0){
            throw new IllegalArgumentException();
        }
    }

    private void validateNotBeyondPurchaseLimit (int purchasePrice) {
        if (purchasePrice > PURCHASE_LIMIT){
            throw new IllegalArgumentException(String.format(BEYOND_LIMIT.getMessage(), PURCHASE_LIMIT));
        }
    }
}
