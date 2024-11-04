package lotto.store.user;

public class Cash {

    private static final int DEFAULT_UNIT = 1000;
    private static final int MAX_AMOUNT = 100000;

    private final int amount;

    private Cash(int amount) {
        validateDefaultUnit(amount);
        validateMaxAmount(amount);
        this.amount = amount;
    }

    public static Cash from(int amount) {
        return new Cash(amount);
    }

    public int getTicketCount() {
        return amount / DEFAULT_UNIT;
    }

    public int getAmount() {
        return amount;
    }

    private void validateDefaultUnit(int amount) {
        if(amount % DEFAULT_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원 입니다.");
        }
    }

    private void validateMaxAmount(int amount) {
        if(amount > MAX_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 1회차당 구매 금액은 최대 10만원 입니다.");
        }
    }

}
