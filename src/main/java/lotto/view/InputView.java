package lotto.view;

import static lotto.view.InputMessage.INPUT_BUDGET;
import static lotto.view.InputMessage.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readBudget() {
        System.out.println(INPUT_BUDGET.getMessage());
        return Console.readLine();
    }

    public static String readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }
}
