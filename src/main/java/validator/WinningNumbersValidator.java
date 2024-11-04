package validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbersValidator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static List<Integer> validate(String winningNumbersInput) {
        List<Integer> winningNumbers = validateIsNumber(winningNumbersInput);
        validateNumberRange(winningNumbers);
        validateNoDuplicates(winningNumbers);
        validateNumberCount(winningNumbers);
        return winningNumbers;
    }

    private static void validateNumberRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateNoDuplicates(List<Integer> winningNumbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(winningNumbers);
        if (noDuplicateNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
    }

    private static void validateNumberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자로 입력해야 합니다.");
        }
    }

    private static List<Integer> validateIsNumber(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자 형태로 입력해야 합니다.");
        }
    }
}
