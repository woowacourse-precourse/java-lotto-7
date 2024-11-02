package lotto.domain;

public class PurchasePrice {
    public static final int LOTTO_UNIT = 1000;
    private static final String MIN_PRICE_ERROR = "[ERROR] 로또의 가격은 1000원 입니다. 돈이 부족합니다.";
    private static final String LOTTO_UNIT_ERROR = "[ERROR] 1000원 단위가 아닙니다.";

    private final int money;

    public PurchasePrice(int money) {
        validateMinPrice(money);
        validatePriceUnit(money);
        this.money = money;
    }

    private void validateMinPrice(int money) {
        if (money < LOTTO_UNIT) {
            throw new IllegalArgumentException(MIN_PRICE_ERROR);
        }
    }

    private void validatePriceUnit(int money) {
        if (money % LOTTO_UNIT != 0) {
            throw new IllegalArgumentException(LOTTO_UNIT_ERROR);
        }
    }

    public int calculateLottoCount() {
        return money / LOTTO_UNIT;
    }

    public int getMoney() {
        return money;
    }
}
