package lotto.exception;

public class NotNumberException extends IllegalArgumentException {
    public NotNumberException() {
        super("숫자를 입력해주셔야 합니다.");
    }
}
