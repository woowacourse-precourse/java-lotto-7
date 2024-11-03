package lotto.exception;

public enum ErrorMessage {
    EMPTY_INPUT_IS_NOT_POSSIBLE("빈 값은 입력할 수 없어요."),

    INVALID_NUMBER_FORMAT("숫자만 입력할 수 있어요."),
    INVALID_SIZE_OF_PURCHASE("0 이하는 입력할 수 없어요."),
    INVALID_PRICE_OF_PURCHASE("1,000원 단위로 구매할 수 있어요."),
    INVALID_COUNT_OF_PURCHASE("최대 100,000원까지 구매할 수 있어요."),

    INVALID_WINNING_NUMBERS_COUNT("6개의 숫자를 입력해 주세요."),
    INVALID_NUMBER_RANGE("1 ~ 45 사이의 숫자만 입력할 수 있어요."),
    INVALID_WINNING_NUMBERS_FORMAT("1,2,3,4,5,6과 같이 6개의 숫자와 콤마로 이루어진 문자열을 입력해 주세요."),
    DUPLICATE_NUMBER_IS_NOT_ALLOWED("중복된 숫자는 입력할 수 없어요."),

    ALREADY_EXIST_IN_WINNING_NUMBERS("당첨 번호에 있는 숫자는 입력할 수 없어요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
