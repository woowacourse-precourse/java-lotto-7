package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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

    public static List<Integer> toNumbers(List<String> inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputs) {
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 6개의 당첨번호를 쉼표(,)로 구분하여 입력해주세요.");
            }
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
