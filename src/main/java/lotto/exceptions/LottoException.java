package lotto.exceptions;

public class LottoException extends RuntimeException {
    public LottoException(String message) {
        super(message);
    }

    // 예외 발생 시 표시할 메시지 반환
    public abstract String getErrorMessage();
}
