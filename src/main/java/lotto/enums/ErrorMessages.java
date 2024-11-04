package lotto.enums;

public enum ErrorMessages {
    ERROR_PREFIX("[ERROR] "),
    ERROR_PRICE_UNDER_ZERO("0이하 값은 입력할 수 없습니다."),
    ERROR_PRICE_NOT_IN_UNITS_OF_1000("금액은 1000원 단위여야 합니다."),
    ERROR_DELIMETER_ONLY_HAS_COMMA("로또 번호는 숫자와 ','만 포함할 수 있습니다."),
    ERROR_DUPLICATE_NUMBER("로또 번호에 중복된 숫자가 포함되어 있습니다."),
    ERROR_NUMBER_UNDER_ZERO_OVER_FORTY_FIVE("로또 번호는 1이상 45이하입니다."),
    ERROR_NUMBER_ONLY_SIX("로또 번호는 6개여야 합니다."),
    ERROR_PRICE_IS_NOT_STRING("구매 가격은 정수만 입력해야합니다."),
    ERROR_LOTTO_NUMBER_IS_SIX("로또 번호는 6개입니다."),
    ERROR_LOTTO_NUMBER_IS_UNIQUE("중복되는 값이 있으면 안됩니다.")
    ;


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public static String printError(ErrorMessages errorMessage) {
        return ERROR_PREFIX.message + errorMessage.message;
    }
}
