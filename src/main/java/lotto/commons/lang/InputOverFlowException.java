package lotto.commons.lang;

public class InputOverFlowException extends RuntimeException {

    public InputOverFlowException() {
        super("입력 기회를 초과하여 프로그램을 종료합니다.");
    }

    public InputOverFlowException(String message) {
        super(message);
    }
}
