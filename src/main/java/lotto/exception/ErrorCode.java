package lotto.exception;

public enum ErrorCode {

    CANT_CONVERT_TO_INTEGER("사용자의 입력을 숫자(int)로 변환하지 못했습니다"),
    PURCHASE_AMOUNT_MUST_BE_OVER_ZERO("구매 가격은 양수만 입력할 수 있습니다"),

    CANT_PURCHASE_AMOUNT_DIVIDE_BY_1000("구매 가격을 1000 단위로 입력해 주십시오");

    private final String message;

    private final String ERROR_PREFIX = "[ERROR] ";

    ErrorCode(final String message){
        this.message = ERROR_PREFIX +message;
    }

    public String getMessage(){
        return this.message;
    }
}
