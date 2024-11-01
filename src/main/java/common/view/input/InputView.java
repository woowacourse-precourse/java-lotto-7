package common.view.input;

import camp.nextstep.edu.missionutils.Console;
import common.view.ViewMessage;

public class InputView {

    public static String getPurchaseAmount() {
        System.out.println(ViewMessage.ENTER_PURCHASE_AMOUNT_MESSAGE);
        String amount = Console.readLine();
        validateBlank(amount);
        System.out.println();
        return amount;
    }

    public static String getWinningNumber() {
        System.out.println(ViewMessage.ENTER_WINNING_NUMBER_MESSAGE);
        String number = Console.readLine();
        validateBlank(number);
        System.out.println();
        return number;
    }

    public static String getBonusNumber() {
        System.out.println(ViewMessage.ENTER_BONUS_NUMBER_MESSAGE);
        String bonus = Console.readLine();
        validateBlank(bonus);
        System.out.println();
        return bonus;
    }

    private static void validateBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

}
