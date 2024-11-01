package lotto.utils.validator;

public class PurchasePriceValidator implements Validator<String> {
    private final int LOTTO_PRICE = 1000;
    private final int PURCHASE_LIMIT = 100000;

    @Override
    public void validate(String rawPurchasePrice) {
        validateNotEmpty(rawPurchasePrice);
        validateNumber(rawPurchasePrice);
        validateInt(rawPurchasePrice);

        int purchasePrice = Integer.parseInt(rawPurchasePrice);
        validatePositiveInt(purchasePrice);
        validateDividedByLottoPrice(purchasePrice);
        validateNotBeyondPurchaseLimit(purchasePrice);
    }

    private void validateNotEmpty(String rawPurchasePrice) {
        if (rawPurchasePrice.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    private void validateNumber(String rawPurchasePrice) {
        try{
            Double.parseDouble(rawPurchasePrice);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다");
        }
    }


    private void validateInt (String rawPurchasePrice) {
        try{
            Integer.parseInt(rawPurchasePrice);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 정수가 아닙니다");
        }
    }

    private void validatePositiveInt (int purchasePrice) {
        if (purchasePrice <= 0) {
            throw new IllegalArgumentException("입력값이 양의 정수가 아닙니다");
        }
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
