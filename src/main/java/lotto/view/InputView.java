package lotto.view;

import static lotto.view.ViewConstant.INPUT_BONUS_NUMBER_PROMPT;
import static lotto.view.ViewConstant.INPUT_MONEY_PROMPT;
import static lotto.view.ViewConstant.INPUT_WINNING_NUMBER_PROMPT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputMoney() {
        System.out.println(INPUT_MONEY_PROMPT);

        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_PROMPT);

        return Console.readLine();
    }

    public String inputWinningBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_PROMPT);

        return Console.readLine();
    }
}
