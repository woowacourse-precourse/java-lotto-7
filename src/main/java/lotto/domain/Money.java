package lotto.domain;

public class Money {
    public final int amount;
    public static final int DIVIDE_CONDITION = 1000;
    public final int trial;

    public Money(int amount) {
        validateAmount(amount);
        this.amount = amount;
        this.trial = amount / DIVIDE_CONDITION;
    }

    private void validateAmount(int amount) {
        if (amount % DIVIDE_CONDITION != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
        }
    }
}