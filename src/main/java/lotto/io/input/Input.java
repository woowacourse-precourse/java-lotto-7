package lotto.io.input;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private Input() {
    }

    public static String getPriceInput() {
        return Console.readLine();
    }

    public static void close() {
        Console.close();
    }
}