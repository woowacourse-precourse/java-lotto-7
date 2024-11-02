package lotto.domain;

public class Wallet {

    private static final Integer MIN_MONEY_UNIT = 1000;
    private static final Integer MIN_MONEY_UNIT_CHECK_NUMBER = 0;

    private final Integer money;

    public Wallet(Integer money) {
        validate(money);
        this.money = money;
    }

    public static Wallet create(Integer money) {
        return new Wallet(money);
    }

    private void validate(Integer money) {
        if (money % MIN_MONEY_UNIT != MIN_MONEY_UNIT_CHECK_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getMoney() {
        return money;
    }
}
