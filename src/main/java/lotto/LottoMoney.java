package lotto;

public class LottoMoney {

    private int money;

    private static final String INVALID_MONEY_MESSAGE = "구매 금액은 1000원 단위여야 합니다.";
    private static final int LOTTO_PRICE_UNIT = 1000;

    public LottoMoney(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money != 0 && money % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_MESSAGE);
        }
    }

    public int getPurchaseCount() {
        return money / LOTTO_PRICE_UNIT;
    }

    public int getMoney() {
        return money;
    }
}