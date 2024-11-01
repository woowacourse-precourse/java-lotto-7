package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
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
        return Collections.unmodifiableList(numbers);
    }

    private static class Validator {

        private static final String COMMA = ",";
        private static final String BONUS_NUMBER_NUMERIC_REGEX = "-?\\d+";
        private static final int WINNING_NUMBERS_SIZE = 6;
        private static final int MINIMUM_WINNING_NUMBER = 1;
        private static final int MAXIMUM_WINNING_NUMBER = 45;

        private static List<Integer> validateWinningNumbers(String numbers) {
            validateWinningNumbersIsNotEmpty(numbers);
            List<String> delimitedWinningNumbers = validateWinningNumbersDelimiter(numbers);
            validateWinningNumbersCount(delimitedWinningNumbers);
            List<Integer> positiveWinningNumbers = validateWinningNumbersIsNumeric(delimitedWinningNumbers);
            validateWinningNumbersInRange(positiveWinningNumbers);
            validateUniqueWinningNumbers(positiveWinningNumbers);
            return positiveWinningNumbers;
        }

        private static void validateWinningNumbersIsNotEmpty(String numbers) {
            if (numbers == null || numbers.isBlank()) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 비어있을 수 없습니다.");
            }
        }

        private static List<String> validateWinningNumbersDelimiter(String numbers) {
            if (numbers.contains(COMMA)) {
                return Arrays.stream(numbers.split(COMMA))
                        .toList();
            }
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분합니다.");
        }

        private static void validateWinningNumbersCount(List<String> delimitedWinningNumbers) {
            if (delimitedWinningNumbers.size() != WINNING_NUMBERS_SIZE) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
            }
        }

        private static List<Integer> validateWinningNumbersIsNumeric(List<String> delimitedWinningNumbers) {
            for (String delimitedWinningNumber : delimitedWinningNumbers) {
                if (!delimitedWinningNumber.matches(BONUS_NUMBER_NUMERIC_REGEX)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
                }
            }
            return delimitedWinningNumbers.stream()
                    .map(Integer::parseInt)
                    .toList();
        }

        private static void validateWinningNumbersInRange(List<Integer> positiveWinningNumbers) {
            boolean hasOutOfRangeNumber = positiveWinningNumbers.stream()
                    .anyMatch(lottoNumber -> lottoNumber < MINIMUM_WINNING_NUMBER || lottoNumber > MAXIMUM_WINNING_NUMBER);

            if (hasOutOfRangeNumber) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자만 가능합니다.");
            }
        }

        private static void validateUniqueWinningNumbers(List<Integer> positiveWinningNumbers) {
            int positiveWinningNumbersSize = new HashSet<>(positiveWinningNumbers).size();
            if (positiveWinningNumbersSize != positiveWinningNumbers.size()) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
            }
        }

    }

}