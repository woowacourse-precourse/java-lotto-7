package lotto;

public class LottoAmount {
    private int amount;

    public LottoAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 이상 가능합니다.");
        }

        int change = amount % 1000;
        if (change != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 단위로 가능합니다.");
        }
    }

    public int getAmount() {
        return amount;
    }
}
