package lotto.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.LottoConstants.*;

public class NumbersValidator {
    private enum ErrorMessage {
        MUST_BE_TARGET_LENGTH("%s %s 번호는 %d개이어야 합니다."),
        MUST_BE_NUMBER("%s 로또 번호는 숫자 형식이어야 합니다."),
        MUST_BE_UNIQUE("%s 로또 번호가 중복되었습니다.");

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
    }

    public void validateBonusNumber() {
        validateLength("보너스");
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

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
