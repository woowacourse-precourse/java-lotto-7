package lotto.domain.exception;

public class InputException extends RuntimeException {

    public InputException() {
        super();
    }

    public InputException(String message) {
        super(message);
    }

    public static InputException empty() {
        return new InputException("빈 문자열은 입력할 수 없습니다.");
    }
}
