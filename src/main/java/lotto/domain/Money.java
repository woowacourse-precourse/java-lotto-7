package lotto.domain;

public class Money {
    private final int value;

    private Money(String input) {
        this.value = convertStrToInt(input);
        validate(value);
    }

    public static Money from(String input) {
        return new Money(input);
    }

    private int convertStrToInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
        }
    }

    private void validate(int money) {
        validateMoneyRange(money);
        validateDivisible(money);
    }

    private void validateMoneyRange(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000보다 작을 수 없습니다.");
        }
    }

    private void validateDivisible(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로만 가능합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
