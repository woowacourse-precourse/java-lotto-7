package lotto.view;

import static lotto.utils.Constant.PURCHASE_AMOUNT_INPUT_MESSAGE;
import static lotto.utils.Constant.WINNING_NUMBER_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputParser;

public class InputView {
    private final InputParser inputParser;

    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);

        while (true) {
            String userInput = Console.readLine();

            try {
                return inputParser.parsePurchaseAmount(userInput);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void inputWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);

        String userInput = Console.readLine();
        inputParser.parseWinningNumbers(userInput);
    }
}
