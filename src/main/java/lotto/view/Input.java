package lotto.view;

import static lotto.view.InstructionMessages.INPUT_PURCHASE_AMOUNT;
import static lotto.view.InstructionMessages.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static InputValidator inputValidator = new InputValidator();

    public static int inputPurchaseAmount() {
        Output.printMessage(INPUT_PURCHASE_AMOUNT.getMessage());
        while (true) {
            try {
                String purchaseAmount = readInput();
                inputValidator.validatePurchaseAmount(purchaseAmount);
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
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
