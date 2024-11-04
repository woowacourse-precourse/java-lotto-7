package lotto.exception;

public class BonusNumberOutOfBoundException extends IllegalArgumentException{
    private static final String DEFAULT_MESSAGE = "보너스 번호는 1~45사이의 숫자여야합니다.";

    public BonusNumberOutOfBoundException() {
        super(DEFAULT_MESSAGE);
    }
}
