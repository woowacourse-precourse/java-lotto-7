package lotto.service.user;

import lotto.domain.Money;
import lotto.utils.Parser;

public class MoneyService {

    public Money generateMoney(String purchaseAmount) {
        int convertedPurchaseAmount = Parser.parsingPurchaseAmount(purchaseAmount);
        return new Money(convertedPurchaseAmount);
    }
}
