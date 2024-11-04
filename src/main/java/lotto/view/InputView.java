package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readBudget() {
        PromptMessage.printBudgetInputMessage();
        return readInput();
    }

    public String readWinningNumbers() {
        PromptMessage.printWinningNumbersInputMessage();
        return readInput();
    }

    public String readBonusNumber() {
        PromptMessage.printBonusNumberInputMessage();
        return readInput();
    }

    private String readInput() {
        return Console.readLine();
    }
}
