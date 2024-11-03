package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputMessage;


public class InputView {
    public static String requestLottoPurchase() {
        System.out.println(InputMessage.USER_PURCHASE_AMOUNT_REQUEST);
        return Console.readLine();
    }

    public static String requestWinningNumbers() {
        System.out.println();
        System.out.println(InputMessage.ADMIN_WINNING_NUMBERS_REQUEST);
        return Console.readLine();
    }

    public static String requestBonusNumber() {
        System.out.println();
        System.out.println(InputMessage.ADMIN_BONUS_NUMBER_REQUEST);
        return Console.readLine();
    }

}
