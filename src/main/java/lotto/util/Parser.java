package lotto.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static lotto.common.Error.NOT_INTEGER_NUMBER;

public class Parser {
    private Parser() {
    }

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_NUMBER.getMessage());
        }
    }

    public static List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(",")).map(Parser::parseInt).toList();
    }

    public static String formatMoney(int money) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(money);
    }
}
