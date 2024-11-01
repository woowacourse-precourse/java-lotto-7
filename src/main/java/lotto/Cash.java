package lotto;

public class Cash {

    private static final int DEFAULT_UNIT = 1000;

    private final int amount;

    public Cash(int amount) {
        validateDefaultUnit(amount);
        this.amount = amount;
    }

    private void validateDefaultUnit(int amount) {
        if(amount % DEFAULT_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원 입니다.");
        }
    }

}
