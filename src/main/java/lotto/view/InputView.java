package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.MoneyTypeValidator;

public class InputView {

    private final MoneyTypeValidator moneyTypeValidator;

    public InputView() {
        moneyTypeValidator = new MoneyTypeValidator();
    }

    public int getPurchasedMoney() {
        while (true) {
            try {
                System.out.println(OutputView.INPUT_MONEY_MESSAGE);
                return this.moneyTypeValidator.validateMoneyType(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
