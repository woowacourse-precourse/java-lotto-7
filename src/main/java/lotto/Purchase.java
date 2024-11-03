package lotto;

public class Purchase {
    private final int amount;
    private static final int LOTTO_PRICE = 1000;


    public Purchase(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

}
