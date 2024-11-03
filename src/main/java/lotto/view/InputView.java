package lotto.view;

import static lotto.constant.OutputMessage.INPUT_BUDGET;
import static lotto.constant.OutputMessage.INPUT_BONUS_NUMBER;
import static lotto.constant.OutputMessage.INPUT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputBudget() {
        System.out.println(INPUT_BUDGET.getMessage());
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER.getMessage());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
