package lotto.exception.io;

public class IllegalNumberFormatException extends IllegalArgumentException {

    private static final String MESSAGE = "잘못된 숫자 형식입니다.";

    public IllegalNumberFormatException() {
        super(MESSAGE);
    }
}
