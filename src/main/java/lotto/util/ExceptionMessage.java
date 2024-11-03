package lotto.util;

import static lotto.util.Constants.LOTTO_PRICE;

public enum ExceptionMessage {

    INVALID_NOT_NUMERIC("정수의 형태로 입력하세요."),
    INVALID_OUT_OF_BUDGET_RANGE("구매 금액은 1000원부터 10만원까지 입력 가능합니다."),
    INVALID_RANGE("1부터 45까지의 숫자만 입력 가능합니다."),
    INVALID_UNIT_OF_BUDGET(String.format("%d원 단위로 구매 가능합니다.", LOTTO_PRICE));

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }

}
