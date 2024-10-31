package lotto.view;

import static lotto.util.PrintVariable.FIRST_BUY_MONEY_INPUT;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.util.CustomStringUtils;

public class MoneyInputView {

    public Money inputMoney() {
        while (true) {
            try {
                CustomStringUtils.printStringLineFeed(FIRST_BUY_MONEY_INPUT.value());
                return Money.from(Console.readLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
