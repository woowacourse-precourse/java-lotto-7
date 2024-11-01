package lotto.utils.validator;

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
            throw new IllegalArgumentException("입력 금액이 로또 가격으로 나누어 떨어지지 않습니다");
        }
    }

    private void validateNotBeyondPurchaseLimit (int purchasePrice) {
        if (purchasePrice > PURCHASE_LIMIT){
            throw new IllegalArgumentException(String.format("입력 금액이 1인 구매 가능 금액(%d)을 초과하였습니다", PURCHASE_LIMIT));
        }
    }
}
