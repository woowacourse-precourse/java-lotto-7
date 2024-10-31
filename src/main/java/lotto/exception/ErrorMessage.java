package lotto.exception;

public enum ErrorMessage {
    INVALID_NUMBER_COUNT ("로또 번호는 6개여야 합니다."),
    OUT_OF_RANGE_NUMBER("로또 번호는 1~45이어야 합니다."),
    DUPLICATE_NUMBER("로또 번호는 중복될 수 없습니다.");

    private final static String EXCEPTION_HEADER = "[ERROR] ";
    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return EXCEPTION_HEADER + message;
    }
}
