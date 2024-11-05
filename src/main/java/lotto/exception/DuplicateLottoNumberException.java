package lotto.exception;

public class DuplicateLottoNumberException extends IllegalLottoNumberException {
    private static final String MESSAGE = "로또 번호는 서로 달라야 합니다.";

    public DuplicateLottoNumberException() {
        super(MESSAGE);
    }
}
