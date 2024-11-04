package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Reader {
    public static String readInput() {
        String input = Console.readLine();
        Printer.printMessage(input);
        return input;
    }
}