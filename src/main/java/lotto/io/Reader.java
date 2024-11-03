package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Reader {

    public static int readMoney() {
        String input = Console.readLine();

        return Parser.parseInputToMoney(input);
    }

    public static List<Integer> readWinningNumbers() {
        String input = Console.readLine();

        return Parser.parseInputToNumbers(input);
    }
}
