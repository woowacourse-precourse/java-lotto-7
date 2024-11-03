package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Util {

    private static final String NUMBER_DELIMITER = ",";

    public static List<String> seperateInput(String input) {
        String[] numbersInputs = input.split(NUMBER_DELIMITER);

        return Arrays.stream(numbersInputs)
                .map(String::trim)
                .filter(x -> !x.isEmpty())
                .toList();
    }
}
