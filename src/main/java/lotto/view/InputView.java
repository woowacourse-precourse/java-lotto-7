package lotto.view;

import static lotto.view.InputMessage.INPUT_BONUS_NUMBER;
import static lotto.view.InputMessage.INPUT_BUDGET;
import static lotto.view.InputMessage.INPUT_WINNING_NUMBERS;
import static lotto.view.OutputView.printMessage;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readBudget() {
        printMessage(INPUT_BUDGET.getMessage());
        return Console.readLine();
    }

    public static String readWinningNumbers() {
        printMessage(INPUT_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public static String readBonusNumber() {
        printMessage(INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
