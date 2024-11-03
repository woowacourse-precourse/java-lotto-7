package lotto.exception;

public class InvalidLottoNumbersSizeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";

    public InvalidLottoNumbersSizeException() {
        super(ERROR_MESSAGE);
    }
}
