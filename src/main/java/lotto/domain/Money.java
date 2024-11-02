package lotto.domain;

public class Money {
    private final int money;

    public Money(int money) {
        validatePositive(money);
//        validateIsZero(money);
        validateDivide(money);
        this.money = money;
    }

    private void validatePositive(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("[Error] 금액은 양의 정수여야합니다 ");
        }
    }

    private void validateDivide(int money) {
        if (!(money % 1000 == 0)) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    private void validateIsZero(int money) {
        if(money == 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야합니다");
        }
    }
}
