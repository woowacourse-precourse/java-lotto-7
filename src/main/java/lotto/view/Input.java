package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ViewMessage;

public class Input {

    public static String InputAmount() {
        System.out.println(ViewMessage.INPUT_BUY_AMOUNT.getMessage());
        return Console.readLine();
    }

    public static String InputWinNumber() {
        System.out.println();
        System.out.println(ViewMessage.INPUT_WIN_NUMBER.getMessage());
        return Console.readLine();
    }

    public static String InputBonusNumber() {
        System.out.println();
        System.out.println(ViewMessage.INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
