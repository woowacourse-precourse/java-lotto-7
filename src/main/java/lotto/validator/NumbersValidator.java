package lotto.validator;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.LottoConstants.*;

public class NumbersValidator {
    private enum ErrorMessage {
        MUST_BE_TARGET_LENGTH("%s %s 번호는 %d개이어야 합니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
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
            numbers.add(Integer.parseInt(number));
        }
    }

    public void validateWinningNumbers() {
        validateLength("당첨");
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
}
