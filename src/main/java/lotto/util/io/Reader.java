package lotto.util.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Reader {

    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        return Parser.parseInputToMoney(input);
    }

    public static List<Integer> readWinningNumbers() {
        System.out.printf("%n당첨 번호를 입력해 주세요.%n");
        String input = Console.readLine();

        return Parser.parseInputToNumbers(input);
    }

    public static int readBonusNumber() {
        System.out.printf("%n보너스 번호를 입력해 주세요.%n");
        String input = Console.readLine();

        return Parser.parseInputToNumber(input);
    }
}
