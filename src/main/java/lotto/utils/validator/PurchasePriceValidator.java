package lotto.utils.validator;

import static lotto.exception.ErrorMessages.BEYOND_LIMIT;
import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoConstants.PURCHASE_LIMIT;

public class PurchasePriceValidator implements Validator<String> {

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
        if (purchasePrice % LOTTO_PRICE.getValue() != 0){
            throw new IllegalArgumentException();
        }
    }

    private void validateNotBeyondPurchaseLimit (int purchasePrice) {
        if (purchasePrice > PURCHASE_LIMIT.getValue()){
            throw new IllegalArgumentException(String.format(BEYOND_LIMIT.getMessage(), PURCHASE_LIMIT));
        }
    }
}
