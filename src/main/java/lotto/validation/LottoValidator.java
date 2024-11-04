package lotto.validation;

import java.util.List;

public class LottoValidator {

    private static final String INTEGER_REGEX = "\\d+";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    public static void validateNotEmpty(String input, String message) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + message);
        }
    }

    public static void validateIsNumber(String input, String message) {
        if (!input.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + message);
        }
    }

    public static void validateRange(int number, String message) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE + message);
        }
    }

    public static void validateDivisibleBy(int number, int divisor, String message) {
        if (number % divisor != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + message);
        }
    }

    public static void validateUniqueBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "당첨 번호와 보너스 번호가 중복되었습니다.");
        }
    }

}
