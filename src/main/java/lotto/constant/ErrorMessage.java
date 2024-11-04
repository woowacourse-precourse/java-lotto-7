package lotto.constant;

public enum ErrorMessage {
    EMPTY_INPUT("[ERROR] 공백은 입력할 수 없습니다"),
    INVALID_PURCHASE_PRICE("[ERROR] 구입 금액은 숫자만 가능합니다"),
    NEGATIVE_NUMBER("[ERROR] 양수만 가능합니다"),
    NOT_MULTIPLE_OF_THOUSAND("[ERROR] 1000의 배수가 아닙니다"),
    INVALID_NUMBER_RANGE("[ERROR] 6개의 1에서 45사이의 숫자만 (,)로 구분해서 입력 가능합니다")
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
