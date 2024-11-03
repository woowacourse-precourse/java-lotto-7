package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.ConsoleMessage;

public class BudgetInputView extends View {

    @Override
    protected void printMessage() {
        System.out.println(ConsoleMessage.BUDGET_INPUT);
    }

    @Override
    protected String doRendering() {
        return Console.readLine();
    }
}
