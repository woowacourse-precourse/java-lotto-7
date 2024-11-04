package lotto.exception;

public class InvalidSizeLottoNumberException extends IllegalArgumentException {
    private final static String ERROR_MESSAGE = "[ERROR] 당첨 번호는 6개여야 합니다.";

    public InvalidSizeLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}
