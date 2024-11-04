package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.messageType.InputMessageType;

public class InputMessage {

    public static String inputClientMoney() {
        System.out.println(InputMessageType.INPUT_MONEY_GUIDE_MESSAGE.getMessage());
        return Console.readLine().trim();
    }

    public static String inputWinningNumbers() {
        System.out.println(InputMessageType.INPUT_WINNING_NUMBERS_MESSAGE.getMessage());
        return Console.readLine().trim();
    }

    public static String inputBonusNumber() {
        System.out.println(InputMessageType.INPUT_BONUS_NUMBER_MESSAGE.getMessage());
        return Console.readLine().trim();
    }
}
