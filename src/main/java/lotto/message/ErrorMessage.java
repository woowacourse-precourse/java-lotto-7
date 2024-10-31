package lotto.message;

public enum ErrorMessage {
    NOT_NUMERIC_ERROR("입력 값은 정수여야 합니다.");

    private static final String ERROR_FLAG = "[ERROR]";

    private String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return String.format(ERROR_FLAG + message);
    }

}
