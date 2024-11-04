package lotto.exception;

public class LottoException extends IllegalArgumentException {
    private static final String ERROR = "[ERROR] ";
    private final ErrorMessage errorMessage;

    public LottoException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    /**
     * 콘솔에 출력할 에러 메세지 가져오기
     *
     * @return 에러 메시지
     */
    public String makeErrorMessage() {
        return ERROR + errorMessage.getMessage();
    }
}
