package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String BUY_LOTTO_ERROR_MESSAGE = ERROR_MESSAGE + "%d원 단위로 입력해주세요.";
    public static final int ZERO = 0;
    private static final int PERCENT = 100;

    private int money;

    private Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private static void validateMoney(int money) {
        if (isNotMultipleOfLottoPrice(money)) {
            throw new IllegalArgumentException(String.format(BUY_LOTTO_ERROR_MESSAGE, LOTTO_PRICE));
        }
    }

    private static boolean isNotMultipleOfLottoPrice(int money) {
        return money % LOTTO_PRICE != ZERO;
    }

    public static Money from(int money) {
        return new Money(money);
    }

    public Money plus(Money otherMoney) {
        return from(this.money + otherMoney.money);
    }

    public int countOfBuyLotto() {
        return this.money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }

    public double calculateProfitRatio(Money totalPrize) {
        return (double) totalPrize.money / this.money * PERCENT;
    }
}
