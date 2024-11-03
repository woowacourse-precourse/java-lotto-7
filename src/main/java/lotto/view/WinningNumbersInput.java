package lotto.view;

import static lotto.view.InstructionMessages.INPUT_WINNING_NUMBERS;

public class WinningNumbersInput implements Input {
    @Override
    public String input() {
        Output.printMessage(INPUT_WINNING_NUMBERS.getMessage());
        while (true) {
            try {
                String winningNumbers = readInput();
                validate(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void validate(String input) {

    }
}
