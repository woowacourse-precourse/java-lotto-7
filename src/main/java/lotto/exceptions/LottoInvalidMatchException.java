package lotto.exceptions;

public class LottoInvalidMatchException extends IllegalStateException{
    private static final String MESSAGE = "[ERROR] 로또 당첨횟수가 유효하지 않습니다.";
    public LottoInvalidMatchException() {
        super(MESSAGE);
    }
}
