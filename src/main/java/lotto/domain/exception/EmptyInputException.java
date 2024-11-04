package lotto.domain.exception;

public class EmptyInputException extends RuntimeException {

    public EmptyInputException() {
        super();
    }

    public EmptyInputException(String message) {
        super(message);
    }

    public static EmptyInputException empty() {
        return new EmptyInputException("빈 문자열은 입력할 수 없습니다.");
    }
}
