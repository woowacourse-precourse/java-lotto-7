package lotto.domain;

public class Money {
    private final int value;

    public Money(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 0보다 작을 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }

    public static Money from(String money) {
        return new Money(Integer.parseInt(money));
    }
}
