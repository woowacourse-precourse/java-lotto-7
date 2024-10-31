package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputLottoNumbersValidator {
    private enum ErrorMessage {
        DEFAULT_HEADER("[ERROR] "),
        INVALID_NUMBERS_SIZE("로또 번호는 6개여야 합니다."),
        INVALID_NUMBERS_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        INVALID_DUPLICATES_NUMBER("로또 번호에는 중복된 숫자가 있을 수 없습니다."),
        INVALID_DUPLICATE_WINNING_NUMBERS("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

        private String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }

    public static void validateWinningNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumberRange(numbers);
        validateNoDuplicates(numbers);
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberRange(bonusNumber);
        validateNoDuplicateWithWinningNumbers(bonusNumber, winningNumbers);
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    ErrorMessage.DEFAULT_HEADER.getMessage() + ErrorMessage.INVALID_NUMBERS_SIZE.getMessage());
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(
                        ErrorMessage.DEFAULT_HEADER.getMessage() + ErrorMessage.INVALID_NUMBERS_RANGE.getMessage());
            }
        }
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(
                    ErrorMessage.DEFAULT_HEADER.getMessage() + ErrorMessage.INVALID_DUPLICATES_NUMBER.getMessage());
        }
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(
                    ErrorMessage.DEFAULT_HEADER.getMessage() + ErrorMessage.INVALID_NUMBERS_RANGE.getMessage());
        }
    }

    private static void validateNoDuplicateWithWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    ErrorMessage.DEFAULT_HEADER.getMessage() + ErrorMessage.INVALID_DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }
}
