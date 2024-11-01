package lotto.io.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    private Input() {
    }

    public static int getPriceInput() {
        String priceAsString = Console.readLine();
        int price = Integer.parseInt(priceAsString);

        InputValidator.validatePriceIsInThousandUnit(price);

        return price;
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