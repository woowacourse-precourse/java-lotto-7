package lotto.domain;

public class PurchasePrice {
    public static final int LOTTO_UNIT = 1000;
    private static final int ZERO = 0;

    private final int money;

    public PurchasePrice(int money) {
        validateMinPrice(money);
        validatePriceUnit(money);
        this.money = money;
    }

    private void validateMinPrice(int money) {
        if (money < LOTTO_UNIT) {
            throw new IllegalArgumentException("[ERROR] 로또의 가격은 1000원 입니다. 돈이 부족합니다.");
        }
    }

    private void validatePriceUnit(int money) {
        if (money % LOTTO_UNIT != ZERO) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위가 아닙니다.");
        }
    }

    public int calculateLottoCount() {
        return money / LOTTO_UNIT;
    }

    public int getMoney() {
        return money;
    }
}
