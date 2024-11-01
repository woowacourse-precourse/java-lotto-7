package lotto;

public class Purchase {

    private static final int PURCHASE_SCALE = 1_000;
    private static final int MIN_PURCHASE = 1_000;
    private static final int MAX_PURCHASE = 100_000;
    private final int price;

    public Purchase(int price) {
        validatePurchaseRange(price);
        validatePurchaseScale(price);
        this.price = price;
    }

    private void validatePurchaseRange(int price) {
        if (price < MIN_PURCHASE || price > MAX_PURCHASE) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 " + MIN_PURCHASE + "원 이상, " + MAX_PURCHASE + "원 이하의 수여야 합니다. (1000원 단위 입력)");
        }
    }

    private void validatePurchaseScale(int price) {
        if (price % PURCHASE_SCALE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력되어야 합니다.");
        }
    }
}
