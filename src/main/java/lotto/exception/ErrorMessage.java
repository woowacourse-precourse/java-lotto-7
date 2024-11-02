package lotto.exception;

public enum ErrorMessage {

    UNEXPECTED_EXCEPTION("예기치 못한 오류입니다."),
    INVALID_INPUT("유효하지 않은 입력입니다."),
    INVALID_AMOUNT("유효하지 않은 입력 금액입니다.")

    ;

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
