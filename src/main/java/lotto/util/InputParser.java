package lotto.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private final static String NUMBER_DELIMITER = ",";

    public static Integer parseMoney(String money) {
        try {
            return Integer.parseInt(money.replaceAll(" ",""));
        } catch (NumberFormatException e) {
            System.out.println("error");
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> parseNumbers(String numbers) {
        try {
            return Arrays.stream(numbers.replaceAll(" ","").split(NUMBER_DELIMITER))
                    .map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            System.out.println("error");
            throw new IllegalArgumentException();
        }
    }

    public static Integer parseBonusNumber(String number) {
        try {
            return Integer.parseInt(number.replaceAll(" ",""));
        } catch (NumberFormatException e) {
            System.out.println("error");
            throw new IllegalArgumentException();
        }
    }
}
