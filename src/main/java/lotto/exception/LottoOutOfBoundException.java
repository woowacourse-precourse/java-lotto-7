package lotto.exception;

public class LottoOutOfBoundException extends IllegalArgumentException{
    private static final String DEFAULT_MESSAGE = "로또 번호는 1~45사이여야 합니다.";

    public LottoOutOfBoundException() {
        super(DEFAULT_MESSAGE);
    }
}
