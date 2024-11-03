package lotto.view.exception;

import lotto.exception.CustomException;

public final class InvalidInputException extends IllegalArgumentException implements CustomException {

    private InvalidInputException(String message) {
        super(message);
    }

    public static IllegalArgumentException invalidNumber() {
        return new InvalidInputException("올바른 숫자를 입력해 주세요.");
    }
}
