package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> numbers;

    private WinningNumbers(String numbers) {
        this.numbers = Validator.validateWinningNumbers(numbers);
    }

    public static WinningNumbers from(String numbers) {
        return new WinningNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static class Validator {

        private static List<Integer> validateWinningNumbers(String numbers) {
            validateWinningNumbersIsNotEmpty(numbers);
            List<String> delimitedWinningNumbers = validateWinningNumbersDelimiter(numbers);
            List<Integer> positiveWinningNumbers = validatePositiveWinningNumbers(delimitedWinningNumbers);
            validateWinningNumbersInRange(positiveWinningNumbers);
            return positiveWinningNumbers;
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

        private static List<Integer> validatePositiveWinningNumbers(List<String> delimitedWinningNumbers) {
            for (String delimitedWinningNumber : delimitedWinningNumbers) {
                if (!delimitedWinningNumber.matches("^[1-9]\\d*$")) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 양수만 가능합니다.");
                }
            }
            return delimitedWinningNumbers.stream()
                    .map(Integer::parseInt)
                    .toList();
        }

        private static void validateWinningNumbersInRange(List<Integer> positiveWinningNumbers) {
            boolean hasOutOfRangeNumber = positiveWinningNumbers.stream()
                    .anyMatch(lottoNumber -> lottoNumber < 1 || lottoNumber > 45);

            if (hasOutOfRangeNumber) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자만 가능합니다.");
            }
        }

    }

}