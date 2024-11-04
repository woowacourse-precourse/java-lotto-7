package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constant.ViewConstant.*;

public class InputView {

    public String inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return input();
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return input();
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return input();
    }

    private String input() {
        return readLine().trim();
    }
}
