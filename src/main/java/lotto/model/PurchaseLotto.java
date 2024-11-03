package lotto.model;

import static lotto.message.ErrorMessage.INVALID_MONEY_TYPE;

public class PurchaseLotto {

    private static final String INT_REGEX = "\\d+";

    private final int money;
//    private final List<Lotto> lottoList;

    public PurchaseLotto(String moneyTemp) {
        int money = validate(moneyTemp);
        this.money = money;
//        this.lottoList = lottoList;
    }

    private static int validate(final String moneyTemp) {
        intValidate(moneyTemp);
        return Integer.parseInt(moneyTemp);
    }

    private static void intValidate(String moneyTemp) {
        if (!moneyTemp.matches(INT_REGEX)) {
            throw new IllegalArgumentException(INVALID_MONEY_TYPE.getMessage());
        }
    }
}
