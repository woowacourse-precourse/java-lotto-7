package lotto.view;

import static lotto.resources.Messages.INPUT_BONUS_NUMBER;
import static lotto.resources.Messages.INPUT_MONEY;
import static lotto.resources.Messages.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputHandler inputHandler;

    public InputView(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public String inputMoney() {
        return inputWithValidation(INPUT_MONEY.getMessage(), inputHandler::validateInputNumber);
    }

    public String inputWinningNumbers() {
        return inputWithValidation(INPUT_WINNING_NUMBERS.getMessage(), inputHandler::validateInputWinningNumbers);
    }

    public String inputBonusNumber() {
        return inputWithValidation(INPUT_BONUS_NUMBER.getMessage(), inputHandler::validateInputNumber);
    }

    public String inputWithValidation(final String prompt, final ValidatorFunction validatorFunction) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = Console.readLine();
                validatorFunction.validate(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FunctionalInterface
    interface ValidatorFunction {
        void validate(String input);
    }
}
