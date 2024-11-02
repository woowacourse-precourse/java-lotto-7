package lotto.utils.Calculator;

import lotto.constants.Constants;
import lotto.domain.Money;

public class PurchaseCalculator {

    public static int calculateLottoCount(Money money) {
        return money.getMoney() / Constants.ONE_THOUSAND.getValue();
    }
}

