package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.output.Printer;

public class InputView {
    private final InputParser parser;
    private final Printer printer;

    public InputView(InputParser parser, Printer printer) {
        this.parser = parser;
        this.printer = printer;

    }

    public int getPurchaseAmount() {
        while (true) {
            try {
                String amount = Console.readLine();
                return parser.parsePurchaseAmount(amount);

            } catch (NumberFormatException numberFormatException) {
                printer.printError(InputError.IS_NOT_NUMBER);

            } catch (IllegalArgumentException illegalArgumentException) {
                printer.printError(illegalArgumentException.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String winningNumbers = Console.readLine();
                return parser.parseWinningNumbers(winningNumbers);

            } catch (NumberFormatException numberFormatException) {
                printer.printError(InputError.IS_NOT_NUMBER);

            } catch (IllegalArgumentException illegalArgumentException) {
                printer.printError(illegalArgumentException.getMessage());
            }
        }

    }

    public int getBonusNumber() {
        while (true) {
            try {
                String bonusNumber = Console.readLine();
                return parser.parseBonusNumber(bonusNumber);

            } catch (NumberFormatException numberFormatException) {
                printer.printError(InputError.IS_NOT_NUMBER);

            } catch (IllegalArgumentException illegalArgumentException) {
                printer.printError(illegalArgumentException.getMessage());
            }
        }
    }
}
