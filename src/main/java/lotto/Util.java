package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    private static final String NUMBER_DELIMITER = ",";
    static DecimalFormat formatter = new DecimalFormat("#,###");

    public static String cashFormat(int amount) {
        return formatter.format(amount);
    }

    public static String cashFormat(long amount) {
        return formatter.format(amount);
    }

    public static List<String> seperateInput(String input) {
        String[] numbersInputs = input.split(NUMBER_DELIMITER);

        return Arrays.stream(numbersInputs)
                .map(String::trim)
                .filter(x -> !x.isEmpty())
                .toList();
    }

    public static List<Integer> toNumbers(List<String> inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputs) {
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException(Error.INPUT_FORMAT_ERROR.message());
            }
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
