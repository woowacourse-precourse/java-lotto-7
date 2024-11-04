package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersValidator {
    private static final String DELIMITER = ",";
    private static final int REQUIRED_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static List<Integer> validate(String input) {
        validateNullAndEmpty(input);

        String noWhitespace = input.replace(" ", "");
        validateCommaUsage(noWhitespace);

        List<Integer> numbers = parseNumbers(noWhitespace);
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateDuplication(numbers);
        numbers.sort(Integer::compareTo);
        return numbers;
    }

    private static void validateNullAndEmpty(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 입력이 null입니다.");
        }
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다.");
        }
    }

    private static void validateCommaUsage(String input) {
        if (input.contains(",,") || input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 올바른 쉼표 사용이 아닙니다.");
        }
    }

    private static List<Integer> parseNumbers(String input) {
        try {
            return List.of(input.split(DELIMITER)).stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 정수만 입력 가능합니다.");
        }
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 정수여야합니다.");
            }
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }
}
