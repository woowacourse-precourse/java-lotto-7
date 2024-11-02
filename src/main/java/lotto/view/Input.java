package lotto.view;

import static lotto.view.InstructionMessages.INPUT_PURCHASE_AMOUNT;
import static lotto.view.InstructionMessages.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int inputPurchaseAmount() {
        Output.printMessage(INPUT_PURCHASE_AMOUNT.getMessage());
        try {
            return Integer.parseInt(readInput());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static String inputWinningNumbers() {
        Output.printMessage(INPUT_WINNING_NUMBERS.getMessage());
        return readInput();
    }

    private static String readInput() {
        return Console.readLine();
    }
}
