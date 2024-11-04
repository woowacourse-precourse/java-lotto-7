package lotto;

public class Money {
    private final Integer money;

    public Money(Integer money) {
        validate(money);
        this.money = money;
    }

    public Integer getValue() {
        return this.money;
    }

    private void validate(Integer money) {
        if (Math.floorMod(money,1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
