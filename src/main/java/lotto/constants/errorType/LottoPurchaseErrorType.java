package lotto.constants.errorType;

public enum LottoPurchaseErrorType {

    INVALID_MONEY_FORMAT("[ERROR] 로또 구매 금액은 양의 정수만 입력해주세요. (문자 입력 오류)"),
    INVALID_MONEY_NEGATIVE("[ERROR] 로또 구매 금액은 양의 정수만 입력해 주세요. (음수 입력 오류)"),
    INVALID_MONEY_UNIT("[ERROR] 로또 구매 금액은 1000원 단위로 입력해 주세요."),
    INVALID_INPUT_NULL_MONEY("[ERROR] 공백은 입력할 수 없습니다.");

    private final String message;

    LottoPurchaseErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
