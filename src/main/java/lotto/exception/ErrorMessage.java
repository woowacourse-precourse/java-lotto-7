package lotto.exception;

public enum ErrorMessage {

    ERROR_INPUT_EMPTY_OR_NULL("[ERROR] 사용자 입력이 입력되지 않았습니다"),
   ; 

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
