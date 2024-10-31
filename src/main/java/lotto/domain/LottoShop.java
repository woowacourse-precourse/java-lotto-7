package lotto.domain;

public class LottoShop {
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public LottoShop(int money) {
        validateLeastMoney(money);
        validateMoneyInThousandUnit(money);
        this.money = money;
    }

    private void validateLeastMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 최소 천 원 이상부터 구매할 수 있습니다.");
        }
    }

    private void validateMoneyInThousandUnit(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 천 원 단위로만 구매할 수 있습니다.");
        }
    }

    public int calculateLottoGameCount() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }
}
