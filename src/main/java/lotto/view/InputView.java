package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.system.utils.constants.ViewMessages.INVALID_NUMBER_INPUT;

public class InputView {
    public static int inputPurchaseAmount() {
        while (true) {
            try {
                return Integer.parseInt(readUserInput());
            } catch (NumberFormatException e) {
                OutPutView.printMessage(INVALID_NUMBER_INPUT.getMessage());
            }
        }
    }

    public static String inputWinningNumbers() {
        return readUserInput();
    }

    public static int inputBonusNumber() {
        while (true) {
            try {
                return Integer.parseInt(readUserInput());
            } catch (NumberFormatException e) {
                OutPutView.printMessage(INVALID_NUMBER_INPUT.getMessage());
            }
        }
    }

    private static String readUserInput() {
        return readLine();
    }
}
