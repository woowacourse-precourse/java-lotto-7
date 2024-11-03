package lotto.constants;

public enum ErrorMessage {
    ERROR_EMPTY_INPUT("입력값에 공백을 허용하지 않습니다."),
    ERROR_NOT_POSITIVE_NUMBER("양의 정수가 아닌 값은 허용하지 않습니다."),
    ERROR_INVALID_WIN_NUMBERS("당첨 번호는 구분자(,)로 구분할 수 있어야 합니다."),
    ERROR_TRAILING_COMMA("입력값의 마지막에 콤마(,)가 올 수 없습니다."),
    ERROR_LOTTO_NUMBER_RANGE("로또 번호는 1~45 사이여야 합니다."),
    ERROR_LOTTO_PRICE("구입 금액은 1000원 단위로 입력해야 합니다."),
    ERROR_LOTTO_COUNT("로또 번호는 6개여야 합니다."),
    ERROR_LOTTO_NUMBER_DUPLICATE("로또 번호는 중복을 허용하지 않습니다."),
    ERROR_BONUS_NUMBER_DUPLICATE("이미 당첨 번호에 포함되어 있는 번호 입니다.");

    private static final String PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
