package lotto.common.error;


public enum MoneyErrorMessage implements ErrorMessage {

    // 입력 검증 예외 처리
    INVALID_PURCHASE_AMOUNT_UNIT("구입 금액은 1,000원 단위여야 합니다."),
    INVALID_PURCHASE_AMOUNT_VALUE("구입 금액은 0원 이상이어야 합니다.");


    private final String info;
    private final String message;

    MoneyErrorMessage(String message) {
        this.info = ERROR_PREFIX;
        this.message = message;
    }

    @Override
    public String getInfo() {
        return info;
    }
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getInfoMessage() {
        return getInfo() + getMessage();
    }
}
