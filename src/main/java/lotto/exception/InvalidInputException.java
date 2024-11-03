package lotto.exception;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException() {
        super("[ERROR] 숫자를 입력하세요.");
    }
}

