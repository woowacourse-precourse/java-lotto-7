package lotto;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static Integer parseStringToInteger(String input) {
        Integer output = 0;
        try {
            output = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ErrorException.runError("숫자로 입력해야 합니다.");
        }
        return output;
    }

    public List<Integer> parseStringToIntegerList(String input) {
        List<Integer> numberList = Arrays.stream(input.split(","))
                .map(token -> Integer.parseInt(token))
                .collect(Collectors.toList());
        return numberList;
    }

    public String parseIntegerToProcessedInteger(Integer input) {
        return NumberFormat.getInstance().format(input);

    }
}
