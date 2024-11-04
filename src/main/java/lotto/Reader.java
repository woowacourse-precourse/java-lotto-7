package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Reader {
    public static String readInput() {
        String input = "";
        input = Console.readLine();
        Printer.printMessage(input);
        return input;
    }
}