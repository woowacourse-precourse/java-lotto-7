package lotto.io.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    private Input() {
    }

    public static String getPriceInput() {
        return Console.readLine();
    }

    public static List<Integer> getWinningNumbersInput() {
        String winningNumbers = Console.readLine();

        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static void close() {
        Console.close();
    }
}