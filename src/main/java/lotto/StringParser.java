package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    public int convertStringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    public List<Integer> convertStringToIntegerList(String numbers) {
        String[] splitNumbers = numbers.split(",");

        return Arrays.stream(splitNumbers)
                .map(this::convertStringToInt)
                .collect(Collectors.toList());
    }
}
