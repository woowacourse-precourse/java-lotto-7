package lotto.io.reader;

import camp.nextstep.edu.missionutils.Console;

import lotto.exception.InputException;
import lotto.io.printer.DefaultPrinter;
import lotto.util.validator.InputValidator;

public class MoneyReader {

    private static final String MESSAGE_FOR_REQUEST_MONEY = "구입금액을 입력해 주세요.";

    public static long readMoney() {
        String input;
        do {
            DefaultPrinter.printLine(MESSAGE_FOR_REQUEST_MONEY);
            input = Console.readLine();
        } while (!isAvailable(input));

        return Long.parseLong(input);
    }

    private static boolean isAvailable(String moneyInput) {
        try {
            InputValidator.validateMoneyInput(moneyInput);
            return true;
        } catch (InputException exception) {
            DefaultPrinter.printLine(exception.getMessage());
            return false;
        }
    }

}
