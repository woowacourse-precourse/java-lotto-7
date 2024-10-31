package lotto;

public enum ErrorMessage {
    ERROR_PREFIX("[Error]"),
    ERROR_PRICE_UNDER_ZERO("0이하 값은 입력할 수 없습니다."),
    ERROR_PRICE_NOT_IN_UNITS_OF_1000("금액은 1000원 단위여야 합니다."),
    ERROR_DELIMETER_ONLY_HAS_COMMA("로또 번호는 숫자와 ','만 포함할 수 있습니다.")

    ;


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public static String printError(ErrorMessage errorMessage) {
        return ERROR_PREFIX.message + errorMessage.message;
    }
}
