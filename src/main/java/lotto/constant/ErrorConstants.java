package lotto.constant;

public enum ErrorConstants {

    ERROR_MESSAGE_START("[ERROR] "),
    INVALID_PRICE_FORMAT("구입 금액은 숫자여야 합니다.");

    private final String message;

    ErrorConstants(String message){
        this.message = message;
    }

    public String getMessage(){
        return ERROR_MESSAGE_START + message;
    }

}
