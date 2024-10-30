package enums;

public enum ErrorMessage {

    INPUT_NULL("아무런 값을 입력하지 않았습니다."),
    INPUT_ZERO("0을 입력하였습니다."),

    PRICE_UNDER_THOUSAND("1000원 이상의 금액을 입력해야 됩니다."),
    PRICE_NOT_DIVIDE_THOUSAND("1000원 단위로 입력해야 됩니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
