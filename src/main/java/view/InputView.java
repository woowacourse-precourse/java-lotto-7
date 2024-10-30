package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getPurchaseAmount() {
        System.out.println(ViewMessage.ENTER_PURCHASE_AMOUNT_MESSAGE);
        String amount = Console.readLine();
        System.out.println();
        return amount;
    }

    public static String getWinningNumber() {
        System.out.println(ViewMessage.ENTER_WINNING_NUMBER_MESSAGE);
        String number = Console.readLine();
        System.out.println();
        return number;
    }

    public static String getBonusNumber() {
        System.out.println(ViewMessage.ENTER_BONUS_NUMBER_MESSAGE);
        String bonus = Console.readLine();
        System.out.println();
        return bonus;
    }

}
