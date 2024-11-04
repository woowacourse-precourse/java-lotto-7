package lotto.exceptions;

public class LottoShortLengthException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public LottoShortLengthException() {
        super(MESSAGE);
    }
}
