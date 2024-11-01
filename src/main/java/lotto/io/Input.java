package lotto.io;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.io.InstructionMessages.INPUT_PURCHASE_AMOUNT;
import static lotto.io.InstructionMessages.INPUT_WINNINT_NUMBERS;

public class Input {
    public static int inputPurchaseAmount() {
        Output.printMessage(INPUT_PURCHASE_AMOUNT.getMessage());
        return Integer.parseInt(readInput());
    }

    public static String inputWinningNumbers() {
        Output.printMessage(INPUT_WINNINT_NUMBERS.getMessage());
        return readInput();
    }

    private static String readInput() {
        return readLine();
    }
}
