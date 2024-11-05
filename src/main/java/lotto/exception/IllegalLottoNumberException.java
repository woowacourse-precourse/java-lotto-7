package lotto.exception;

public class IllegalLottoNumberException extends IllegalArgumentException {
    private static final String HEADER = "[ERROR] 로또 번호 입력이 올바르지 않습니다. ";

    public IllegalLottoNumberException(String message) {
        super(HEADER + message);
    }
}
