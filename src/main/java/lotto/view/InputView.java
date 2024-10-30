package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.InputMessage;

public class InputView {
    public static String getMoneyInput() {
        System.out.println(InputMessage.MONEY_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String getWinningNumberInput() {
        System.out.println(InputMessage.WINNING_NUMBER_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String getBonusNumberInput() {
        System.out.println(InputMessage.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }
}
