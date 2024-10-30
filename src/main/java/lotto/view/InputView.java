package lotto.view;

import static lotto.utils.Constant.PURCHASE_AMOUNT_INPUT_MESSAGE;
import static lotto.utils.Constant.WINNING_NUMBER_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputValidator;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);

        while (true) {
            String userInput = Console.readLine();

            try {
                return inputValidator.validatePurchaseAmount(userInput);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void inputWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);

        String userInput = Console.readLine();
        inputValidator.validateWinningNumbers(userInput);
    }
}
