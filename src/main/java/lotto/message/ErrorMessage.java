package lotto.message;

public enum ErrorMessage {
    NOT_NUMERIC_ERROR("입력 값은 정수여야 합니다."),
    BUY_AMOUNT_NOT_THOUSAND_UNIT("로또 구입 금액은 1000원 단위로 구매해야 합니다."),
    BUY_AMOUNT_LESS_THAN_THOUSAND("로또 구입 금액은 1000원 이상으로 가능합니다.");

    private static final String ERROR_FLAG = "[ERROR] ";

    private String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return String.format(ERROR_FLAG + message);
    }

}
