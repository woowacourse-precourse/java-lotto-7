package lotto.view;

import static lotto.constants.InputMessage.INPUT_BONUS_MESSAGE;
import static lotto.constants.InputMessage.INPUT_BUDGET_MESSAGE;
import static lotto.constants.InputMessage.INPUT_WINNING_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readPurchasePrice() {
        System.out.println(INPUT_BUDGET_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String readWinningNumber() {
        System.out.println(INPUT_WINNING_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(INPUT_BONUS_MESSAGE.getMessage());
        return Console.readLine();
    }
}
