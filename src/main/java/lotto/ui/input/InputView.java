package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.exception.InputError;
import lotto.exception.ErrorHandler;

public class InputView {
    private final InputParser parser;
    private final ErrorHandler errorHandler;

    public InputView(InputParser parser, ErrorHandler errorHandler) {
        this.parser = parser;
        this.errorHandler = errorHandler;

    }

    public int getPurchaseAmount() {
        while (true) {
            try {
                String amount = Console.readLine();
                return parser.parsePurchaseAmount(amount);

            } catch (NumberFormatException numberFormatException) {
                errorHandler.printError(InputError.IS_NOT_NUMBER);

            } catch (IllegalArgumentException illegalArgumentException) {
                errorHandler.printError(illegalArgumentException.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String winningNumbers = Console.readLine();
                return parser.parseWinningNumbers(winningNumbers);
            } catch (NumberFormatException numberFormatException) {
                errorHandler.printError(InputError.IS_NOT_NUMBER);

            } catch (IllegalArgumentException illegalArgumentException) {
                errorHandler.printError(illegalArgumentException.getMessage());
            }
        }
    }

    public int getBonusNumber() {
        while (true) {
            try {
                String bonusNumber = Console.readLine();
                return parser.parseBonusNumber(bonusNumber);
            } catch (NumberFormatException numberFormatException) {
                errorHandler.printError(InputError.IS_NOT_NUMBER);
            } catch (IllegalArgumentException illegalArgumentException) {
                errorHandler.printError(illegalArgumentException.getMessage());
            }
        }
    }

    public void close() {
        Console.close();
    }
}
