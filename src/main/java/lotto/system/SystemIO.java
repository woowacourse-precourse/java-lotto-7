package lotto.system;

import camp.nextstep.edu.missionutils.Console;

public class SystemIO {

    public static String readUserInput() {
        return Console.readLine();
    }
    public static void showMessageToConsole(Object message) {
        System.out.println(message);
    }
}
