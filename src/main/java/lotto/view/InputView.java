package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Message.ViewMessage;

public class InputView {

    public static String inputAmount() {
        System.out.println(ViewMessage.INPUT_PURCHASE_AMOUNT);
        return Console.readLine().trim();
    }

    public static String inputWinningNum() {
        System.out.println(ViewMessage.INPUT_WINNING_NUMBERS);
        return Console.readLine().trim();
    }

    public static String inputBonusNum() {
        System.out.println(ViewMessage.INPUT_BONUS_NUMBER);
        return Console.readLine().trim();
    }
}
