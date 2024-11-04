package lotto.exception;

public enum ErrorMessage {
    INVALID_MONEY_AMOUNT("로또 구입 금액은 1,000원 단위여야 합니다."),
    INVALID_MONEY_FORMAT("로또 구입 금액 형식이 올바르지 않습니다.")
    ;

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
