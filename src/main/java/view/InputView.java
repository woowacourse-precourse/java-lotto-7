package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {}

    public static String getInputBudget() {
        System.out.print(ViewMessage.INPUT_BUDGET_MESSAGE);
        return Console.readLine();
    }
}
