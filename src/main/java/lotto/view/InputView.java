package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.MoneyValidate;

public class InputView {

    private final MoneyValidate moneyValidate;

    public InputView() {
        moneyValidate = new MoneyValidate();
    }

    public int getPurchasedMoney() {
        while (true) {
            try {
                System.out.println(OutputView.INPUT_MONEY_MESSAGE);
                return this.moneyValidate.validateMoney(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
