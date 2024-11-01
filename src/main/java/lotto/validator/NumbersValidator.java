package lotto.validator;

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
    private List<Integer> numbers;

    public NumbersValidator(List<Integer> numbers, String type) {
        this.numbers = numbers;
    }

    public void validateWinningNumbers() {

    }

    public void validateBonusNumber() {

    }

    private void validateLength(List<Integer> numbers, String type) {
        int targetLength = LENGTH_BY_NUMBER_TYPE.get(type);
        if (numbers.size() != targetLength) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_TARGET_LENGTH.getMessage(type, targetLength));
        }
    }

    private void validateNumbers() {

    }
}
