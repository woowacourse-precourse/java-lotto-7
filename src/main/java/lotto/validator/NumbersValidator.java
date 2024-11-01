package lotto.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lotto.constants.LottoConstants.*;

public class NumbersValidator {
    private enum ErrorMessage {
        MUST_BE_TARGET_LENGTH("%s %s 번호는 %d개이어야 합니다."),
        MUST_BE_NUMBER("%s 로또 번호는 숫자 형식이어야 합니다."),
        MUST_BE_UNIQUE("%s 로또 번호가 중복되었습니다."),
        MUST_BE_NO_SPACE("%s 공백은 허용되지 않습니다."),
        MUST_BE_BETWEEN("%s 로또 번호는 1 ~ 45 사이 숫자이어야 합니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return String.format(message, ERROR_MESSAGE_BEGINNING);
        }

        public String getMessage(String type, int length) {
            return String.format(message, ERROR_MESSAGE_BEGINNING, type, length);
        }
    }

    private final List<Integer> numbers = new ArrayList<>();

    public NumbersValidator(String numbersInput) {
        parseNumbersToList(numbersInput);
    }

    private void parseNumbersToList(String numbersInput) {
        for (String number : numbersInput.split(",")) {
            validateNoSpace(number);
            validateIsNumber(number);
            numbers.add(Integer.parseInt(number));
        }
    }

    private void validateIsNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NUMBER.getMessage());
        }
    }

    public void validateWinningNumbers() {
        validateLength("당첨");
        validateUnique();
        validateBetweenList();
    }

    public void validateBonusNumber() {
        validateLength("보너스");
        validateBetweenList();
    }

    private void validateLength(String type) {
        int targetLength = LENGTH_BY_NUMBER_TYPE.get(type);
        if (numbers.size() != targetLength) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_TARGET_LENGTH.getMessage(type, targetLength));
        }
    }

    private void validateUnique() {
        int beforeSize = numbers.size();
        int afterSize = new HashSet<>(numbers).size();

        if (beforeSize != afterSize) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_UNIQUE.getMessage());
        }
    }

    private void validateNoSpace(String number) {
        int beforeLength = number.length();
        int afterLength = number.strip().length();

        if (beforeLength != afterLength) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NO_SPACE.getMessage());
        }
    }

    private void validateBetweenList() {
        for (int number : numbers) {
            validateBetween(number);
        }
    }

    private void validateBetween(int number) {
        if (number < RANDOM_MIN || RANDOM_MAX < number) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_BETWEEN.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
