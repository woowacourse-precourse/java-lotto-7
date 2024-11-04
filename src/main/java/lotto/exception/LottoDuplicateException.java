package lotto.exception;

public class LottoDuplicateException extends IllegalArgumentException{
    private static final String DEFAULT_MESSAGE = "로또 번호는 중복될 수 없습니다.";

    public LottoDuplicateException() {
        super(DEFAULT_MESSAGE);
    }
}
