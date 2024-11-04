package object;

public class Money {
    private final int money;

    public Money(int money) {
        validateMinimumPrice(money);
        validateBuyRegulation(money);
        this.money = money;
    }

    private void validateMinimumPrice(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("로또 구입 금액은 최소 1000원 입니다.");
        }
    }

    private void validateBuyRegulation(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또는 1000원 단위로 구입할 수 있습니다.");
        }
    }
}
