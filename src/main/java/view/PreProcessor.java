package view;

import model.money.Money;

public class PreProcessor {

    public static Money stringToMoney(String input) {
        long purchaseAmount = Long.parseLong(input);
        return Money.from(purchaseAmount);
    }
}
