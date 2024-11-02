package lotto.enums;

public enum ErrorType {
    INVALID_PURCHASE_RANGE("[ERROR] 구입금액은 1000원 이상이어야 합니다."),
    INVALID_PURCHASE_UNIT("[ERROR] 구입금액은 1000원단위어야 합니다.");

    private final String message;

    ErrorType(String message){
        this.message = message;
    }

    public String getErrorMessage(){
        return message;
    }

}
