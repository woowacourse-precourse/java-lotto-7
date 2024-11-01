package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> numbers;

    private WinningNumbers(String numbers) {
        Validator.validateWinningNumbers(numbers);
        this.numbers = new ArrayList<>();
    }

    public static WinningNumbers from(String numbers) {
        return new WinningNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static class Validator {

        private static void validateWinningNumbers(String numbers) {
            validateWinningNumbersIsNotEmpty(numbers);
            List<String> delimitedWinningNumbers = validateWinningNumbersDelimiter(numbers);
        }

        private static void validateWinningNumbersIsNotEmpty(String numbers) {
            if (numbers == null || numbers.isBlank()) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 비어있을 수 없습니다.");
            }
        }

        private static List<String> validateWinningNumbersDelimiter(String numbers) {
            if (numbers.contains(",")) {
                return Arrays.stream(numbers.split(","))
                        .toList();
            }
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분합니다.");
        }

    }

}