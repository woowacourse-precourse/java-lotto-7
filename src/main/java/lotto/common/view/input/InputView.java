package lotto.common.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.error.CustomException;
import lotto.common.error.ErrorMessage;
import lotto.common.view.ViewMessage;
import java.util.List;

public class InputView {

    public static int getPurchaseAmount() {
        System.out.println(ViewMessage.ENTER_PURCHASE_AMOUNT_MESSAGE);
        String amount = readInput();
        return InputParser.toAmount(amount);
    }

    public static List<Integer> getWinningNumber() {
        System.out.println(ViewMessage.ENTER_WINNING_NUMBER_MESSAGE);
        String number = readInput();
        return InputParser.toLottoNumbers(number);
    }

    public static int getBonusNumber() {
        System.out.println(ViewMessage.ENTER_BONUS_NUMBER_MESSAGE);
        String bonus = readInput();
        return InputParser.toLottoNumber(bonus);
    }

    private static String readInput() {
        String input = Console.readLine();
        validateBlank(input);
        System.out.println();
        return input;
    }

    private static void validateBlank(String input) {
        if (isBlank(input)) {
            throw new CustomException(ErrorMessage.INPUT_NOT_BLANK_ERROR_MESSAGE.toString());
        }
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

}
