package lotto.enums;

public enum ErrorMessage {
    ERROR_MESSAGE_PREFIX("[ERROR] "),

    INVALID_MONEY_INPUT("숫자만 입력할 수 있습니다."),
    NOT_DIVISIBLE_BY_THOUSAND("1000으로 나눌 수 있는 1000 이상의 숫자만 입력할 수 있습니다.");

    private String message;
    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public String format(){
        return ERROR_MESSAGE_PREFIX.getMessage() + message;
    }
}
