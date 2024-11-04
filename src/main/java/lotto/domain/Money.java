package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String BUY_LOTTO_ERROR_MESSAGE = ERROR_MESSAGE + "%d원 단위로 입력해주세요.";
    public static final int ZERO = 0;
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
}
