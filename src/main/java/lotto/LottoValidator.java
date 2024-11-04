package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidator {
    public static List<Integer> validateWinningNumbers(String input) {
        List<Integer> numbers = parseNumbers(input);
        if (numbers.size() != 6 || hasDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 고유한 숫자여야 합니다.");
        }
        return numbers;
    }

    public static int validateBonusNumber(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
        return number;
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static boolean hasDuplicates(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }
}
