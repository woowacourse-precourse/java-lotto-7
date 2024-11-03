package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.ui.ViewConstant.*;

import lotto.validator.MoneyValidator;

public class InputView {
    private static final MoneyValidator moneyValidator = new MoneyValidator();

    public int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String money = input();
        moneyValidator.validateNumeric(money);
        return Integer.parseInt(money);
    }

    private String input() {
        return readLine().trim();
    }
}
