package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class InputValidator {
    private static final int LOTTO_LENGTH = 6;
    private static final int MAX_DIGITS_ALLOWED = 10;
    private static final String DELIMITER = ",";
    private static final String NUMBER_RANGE_PATTERN = "^(?:[1-9]|[1-3][0-9]|4[0-5])$";
    private static final String VALID_NUMBERS_PATTERN = "^[0-9]+(,[0-9]+)*$";
    private static final String VALID_ONLY_NUMBERS_PATTERN = "^[1-9][0-9]*$";

    private static final String ENTERED_TOO_BIG_NUMBER = "[ERROR] 너무 큰 수를 입력하셨습니다.";
    private static final String SIX_NUMBERS_REQUIRED_MESSAGE = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    private static final String VALID_LOTTO_NUMBER_RANGE_MESSAGE = "[ERROR] 1~45 사이의 숫자를 입력해야 합니다.";
    private static final String DUPLICATE_NUMBER_NOT_ALLOWED_MESSAGE = "[ERROR] 중복된 NUMBER가 존재하면 안됩니다.";
    private static final String ONLY_NUMBERS_ALLOWED_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다.";
    private static final String EMPTY_OR_ZERO_NOT_ALLOWED_MESSAGE = "[ERROR] 빈 값 혹은 0은 입력할 수 없습니다.";
    private static final String ONLY_DIVISIBLE_BY_1000_ALLOWED_MESSAGE = "[ERROR] 1000으로 나눠지는 값만 입력할 수 있습니다.";
    private static final String BONUS_NUMBER_DUPLICATE_NOT_ALLOWED_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public void validateInputAmount(String input) {
        validateWithinMaximunRange(input);
        validateNullAndEmptyValue(input);
        validateOnlyNumber(input);
        validateIsDivisibleByThousand(input);
    }

    public void validateInputNumbers(String input) {
        validateDelimitedNumbersFormat(input);
        String[] numbers = input.split(DELIMITER);
        validateEnterSixNumbers(numbers);

        Set<String> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            validateNumberInRange(number);
            validateDuplicateNumber(number, uniqueNumbers);
        }

    }

    private void validateWithinMaximunRange(String input) {
        if (input.length() > MAX_DIGITS_ALLOWED) {
            throw new IllegalArgumentException(ENTERED_TOO_BIG_NUMBER);
        }
    }

    private void validateDelimitedNumbersFormat(String input) {
        if (!input.matches(VALID_NUMBERS_PATTERN)) {
            throw new IllegalArgumentException(SIX_NUMBERS_REQUIRED_MESSAGE);
        }
    }

    public void validateInputBonusNumber(List<Integer> winnerNumbers, String input) {
        validateNumberInRange(input);
        validateBonusNumberNotInWinnerNumbers(winnerNumbers, input);
    }

    private void validateEnterSixNumbers(String[] numbers) {
        if (numbers.length != LOTTO_LENGTH) {
            throw new IllegalArgumentException(SIX_NUMBERS_REQUIRED_MESSAGE);
        }
    }

    private void validateNumberInRange(String number) {
        if (!number.matches(NUMBER_RANGE_PATTERN)) {
            throw new IllegalArgumentException(VALID_LOTTO_NUMBER_RANGE_MESSAGE);
        }
    }

    private void validateDuplicateNumber(String number, Set<String> uniqueNumbers) {
        if (!uniqueNumbers.add(number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_NOT_ALLOWED_MESSAGE);
        }
    }

    private void validateOnlyNumber(String input) {
        if (!input.matches(VALID_ONLY_NUMBERS_PATTERN)) {
            throw new IllegalArgumentException(ONLY_NUMBERS_ALLOWED_MESSAGE);
        }
    }

    private void validateNullAndEmptyValue(String input) {
        if (input == null || input.isEmpty() || input.equals("0")) {
            throw new IllegalArgumentException(EMPTY_OR_ZERO_NOT_ALLOWED_MESSAGE);
        }
    }

    private void validateIsDivisibleByThousand(String input) {
        int number = Integer.parseInt(input);
        if (number <= 0 || number % 1000 != 0) {
            throw new IllegalArgumentException(ONLY_DIVISIBLE_BY_1000_ALLOWED_MESSAGE);
        }
    }

    private void validateBonusNumberNotInWinnerNumbers(List<Integer> winnerNumbers, String input) {
        int bonusNumber = Integer.parseInt(input);
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_NOT_ALLOWED_MESSAGE);
        }
    }
}
