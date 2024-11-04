package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.enumerate.InputPrint.*;

public class InputView {

    public String promptForBudget() {
        return promptUser(INPUT_YOUR_BUDGET.getMsg());
    }

    public String promptForWinningNumbers() {
        return promptUser(INPUT_WIN_NUMBER.getMsg());
    }

    public String promptForBonusNumber() {
        return promptUser(INPUT_BONUS_NUMBER.getMsg());
    }

    private String promptUser(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
