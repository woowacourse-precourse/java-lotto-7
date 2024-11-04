package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Reader {
    public static String readInput() {
        String input = "";
        try {
            input = Console.readLine();
            Printer.printMessage(input);
        } catch (NoSuchElementException e) {
            ErrorHandler.throwException(Constants.INPUT_ERROR_EMPTY);
        }
        return input;
    }
}