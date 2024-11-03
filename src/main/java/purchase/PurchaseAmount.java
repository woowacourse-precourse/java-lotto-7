package purchase;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public PurchaseAmount(int amount) {
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public int getAmount() {
        return amount;
    }

    public int calculateLottoCount() {
        return amount / LOTTO_PRICE;
    }

}
