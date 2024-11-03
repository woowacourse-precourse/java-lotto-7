package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.validator.MoneyValidator;

public class InputView {
    private static final MoneyValidator moneyValidator = new MoneyValidator();

    public int inputMoney() {
        String money = input();
        moneyValidator.validateNumeric(money);
        return Integer.parseInt(money);
    }

    private String input() {
        return readLine().trim();
    }
}
