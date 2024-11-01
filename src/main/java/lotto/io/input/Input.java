package lotto.io.input;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Input {

    private Input() {
    }

    public static BigDecimal getPriceInput() {
        long price = Long.parseLong(Console.readLine());

        return new BigDecimal(price);
    }

    public static List<Integer> getWinningNumbersInput() {
        String winningNumbers = Console.readLine();

        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static int getBonusNumberInput() {
        return Integer.parseInt(Console.readLine());
    }

    public static void close() {
        Console.close();
    }
}