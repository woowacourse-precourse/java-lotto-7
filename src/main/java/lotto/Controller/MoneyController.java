package lotto.Controller;

import lotto.View.Input;
import lotto.Validation.MoneyValidation;

public class MoneyController {
    private int money;

    public int PayMoney() {
        while (true) {
            try {
                String MoneyInput = Input.GetMoney();
                MoneyValidation(MoneyInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Input.Attempt(money);
        return money;
    }

    public void MoneyValidation(String MoneyInput) {
        MoneyValidation.MoneyInputNotNull(MoneyInput);
        MoneyValidation.MoneyIsNumeric(MoneyInput);
        money = Integer.parseInt(MoneyInput);
        MoneyValidation.MoneyDivisibleByThousand(money);
    }
}
