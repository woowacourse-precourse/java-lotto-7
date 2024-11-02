package lotto.commons.lang;

public class InputOverFlowException extends RuntimeException {

    public InputOverFlowException() {
        super("입력 기회를 초과하였습니다.");
    }

    public InputOverFlowException(String message) {
        super(message);
    }
}
