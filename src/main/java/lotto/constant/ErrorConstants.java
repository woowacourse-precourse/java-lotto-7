package lotto.constant;

public enum ErrorConstants {

    ERROR_MESSAGE_START("[ERROR] "),
    INVALID_PRICE_FORMAT("구입 금액은 숫자 혹은 1000원 단위여야 합니다."),
    NULL_NOT_ALLOWED("NULL 은 허용되지 않습니다."),
    NEGATIVE_PRICE_NOT_ALLOWED("구입 금액은 양수여야 합니다.");


    private final String message;

    ErrorConstants(String message){
        this.message = message;
    }

    public String getMessage(){
        return ERROR_MESSAGE_START + message;
    }

}
