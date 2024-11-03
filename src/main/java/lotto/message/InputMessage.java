package lotto.message;

public enum InputMessage {

    // View message
    REQUEST_INPUT_AMOUNT("구입금액을 입력해 주세요."),

    // Error message
    INVALID_INPUT_AMOUNT("숫자로 입력해 주십시오."),
    OUT_OF_RANGE_AMOUNT("1등 당첨 금액보다 큰 액수만큼 구매할 수 없습니다."),
    IS_NOT_DIVISIBLE_BY_1000("1000원 단위로 입력해주십시오.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
