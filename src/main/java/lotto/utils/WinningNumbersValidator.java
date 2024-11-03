package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersValidator {

    public static void validateWinningNumbers(List<String> inputNumbers) {
        validateAllNumeric(inputNumbers);
        validateInRange(inputNumbers);
        validateNoDuplicates(inputNumbers);
        validateSize(inputNumbers);
    }

    private static void validateAllNumeric(List<String> inputNumbers) {
        for (String number : inputNumbers) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력된 값 중 숫자가 아닌 값이 있습니다.");
            }
        }
    }

    private static void validateInRange(List<String> inputNumbers) {
        for (String number : inputNumbers) {
            int num = Integer.parseInt(number);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("숫자는 1에서 45 사이여야 합니다.");
            }
        }
    }

    private static void validateNoDuplicates(List<String> inputNumbers) {
        Set<String> uniqueNumbers = new HashSet<>(inputNumbers);
        if (uniqueNumbers.size() != inputNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
        }
    }

    private static void validateSize(List<String> inputNumbers) {
        if (inputNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
    }

}
