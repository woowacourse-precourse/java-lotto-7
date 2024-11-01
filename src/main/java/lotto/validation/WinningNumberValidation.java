package lotto.validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberValidation {
    private final static String INVALID_WINNING_NUMBER_INPUT = "[ERROR] 올바른 당첨 번호를 입력해 주세요";


    public static List<Integer> parseValidatedWinningNumber(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_INPUT);
        }
        List<Integer> numbers = Arrays.stream(input.replaceAll("\\s", "").split(","))
                .filter(s -> !s.isBlank())
                .map(Integer::parseInt)
                .toList();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_INPUT);
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(INVALID_WINNING_NUMBER_INPUT);
            }
        }
        return numbers;
    }
}
