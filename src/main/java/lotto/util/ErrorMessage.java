package lotto.util;

public enum ErrorMessage {

    ERROR_PREFIX("[ERROR] "),

    PURCHASE_AMOUNT_NOT_DIVISION_ERROR(ERROR_PREFIX.message + "입력하신 금액이 나누어떨어지지 않습니다. "),
    WINNING_NUMBERS_SIZE_ERROR(ERROR_PREFIX.message + "당첨번호는 6개여야합니다. "),
    WINNING_NUMBERS_DUPLICATE_ERROR(ERROR_PREFIX.message + "당첨번호는 중복되지 않아야합니다. "),
    LOTTO_NUMBER_OUT_OF_RANGE_ERROR(ERROR_PREFIX.message + "로또 번호는 1 ~ 46 사이의 숫자여야 합니다. "),
    INVALID_INPUT_TYPE_INT(ERROR_PREFIX.message + "잘못된 입력입니다. 숫자를 입력해주세요. ")
    ;


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
