package lotto.constant;

public enum ErrorConstants {

    ERROR_MESSAGE_START("[ERROR] "),
    EMPTY_VALUE_NOT_ALLOWED("빈 값은 허용되지 않습니다."),
    INVALID_PRICE_FORMAT("구입 금액은 숫자 혹은 1000원 단위여야 합니다."),
    NULL_NOT_ALLOWED("NULL 은 허용되지 않습니다."),
    NEGATIVE_PRICE_NOT_ALLOWED("구입 금액은 양수여야 합니다."),
    INVALID_WINNING_NUMBER_FORMAT("당첨 번호는 1 ~ 45 사이 숫자여야 합니다."),
    INVALID_LOTTO_COUNT("로또 번호는 6개여야 합니다."),
    EXCEEDED_MAX_RANGE("최대치를 초과한 가격입니다."),
    DUPLICATE_NOT_ALLOWED("중복된 당첨번호는 허용되지 않습니다.");


    private final String message;

    ErrorConstants(String message){
        this.message = message;
    }

    public String getMessage(){
        return ERROR_MESSAGE_START.message + message;
    }

}
