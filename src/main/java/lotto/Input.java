package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int intInput() {
        return Integer.parseInt(Console.readLine());
    }

    public static String stringInput() {
        return Console.readLine();
    }

}
