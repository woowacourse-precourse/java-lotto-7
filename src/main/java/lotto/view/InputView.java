package lotto.view;

import static lotto.utils.Constant.BONUS_NUMBER_INPUT_MESSAGE;
import static lotto.utils.Constant.PURCHASE_AMOUNT_INPUT_MESSAGE;
import static lotto.utils.Constant.WINNING_NUMBER_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
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

    public List<Integer> inputWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);

        while (true) {
            String userInput = Console.readLine();

            try {
                return inputParser.parseWinningNumbers(userInput);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);

        while (true) {
            String userInput = Console.readLine();

            try {
                return inputParser.parseBonusNumber(userInput, winningNumbers);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
