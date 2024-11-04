package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.Constant;
import lotto.error.ErrorMessage;

public class WinningNumberValidator {

    public static void validate(String winningNumbers) {
        if (!validateNotBlank(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK.getMessage());
        }
        validateValidToken(winningNumbers);
        validateLottoNumber(winningNumbers);
    }

    private static boolean validateNotBlank(String winningNumbers) {
        return !winningNumbers.isBlank();
    }

    private static void validateValidToken(String winningNumbers) {
        String[] numbersToken = winningNumbers.split(Constant.COMMA_SEPARATOR);
        for (String s : numbersToken) {
            if (s.isBlank()) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_BLANK.getMessage());
            }
            if (!validateOnlyNumbers(s.trim())) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ALLOWED_CHARS.getMessage());
            }
        }
    }

    private static void validateLottoNumber(String winningNumbers) {
        List<Integer> numbers = Arrays.stream(winningNumbers.split(Constant.COMMA_SEPARATOR))
                .map(Integer::parseInt)
                .toList();

        if (numbers.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBERS.getMessage());
        }
        if (!validateDuplication(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_DUPLICATE.getMessage());
        }
        if (!validateInRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_NOT_IN_RANGE.getMessage());
        }
    }

    private static boolean validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == Constant.LOTTO_SIZE;

    }

    private static boolean validateInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> Constant.MIN_NUMBER <= number && number <= Constant.MAX_NUMBER);
    }

    private static boolean validateOnlyNumbers(String winningNumber) {
        String pattern = "^[0-9]{1,2}$";
        return winningNumber.matches(pattern);
    }
}
