package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class Reader {

    public static int readMoney() {
        String input = Console.readLine();

        return Parser.parseInputToMoney(input);
    }
}
