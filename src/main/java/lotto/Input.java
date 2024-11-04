package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String readConsole() {
        return Console.readLine();
    }

    public static Integer getUserInputAsInteger() {
        String inputString = readConsole();
        return Parser.parseStringToInteger(inputString);
    }

}
