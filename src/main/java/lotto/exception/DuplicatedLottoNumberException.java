package lotto.exception;

public class DuplicatedLottoNumberException extends IllegalArgumentException {
    private final static String ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지않는 정수여야 합니다.";

    public DuplicatedLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}
