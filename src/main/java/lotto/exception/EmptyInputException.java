package lotto.exception;

public class EmptyInputException extends IllegalArgumentException {
    public EmptyInputException() {
        super("입력값을 작성해주세요.");
    }
}
