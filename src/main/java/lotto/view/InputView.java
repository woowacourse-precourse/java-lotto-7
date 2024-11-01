package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readBudget() {
        InputPrompt.printBudgetInputMessage();
        return readInput();
    }

    public String readWinningNumbers() {
        InputPrompt.printWinningNumbersInputMessage();
        return readInput();
    }

    public String readBonusNumber() {
        InputPrompt.printBonusNumberInputMessage();
        return readInput();
    }

    private String readInput() {
        return Console.readLine();
    }
}
