package lotto.model;

public class LottoAmount {
    private static final int THOUSAND_UNIT = 1000;
    private final int amount;

    public LottoAmount(String input) {
        this.amount = Integer.parseInt(input);
    }

    public int getAmount() {
        return amount / THOUSAND_UNIT;
    }
}