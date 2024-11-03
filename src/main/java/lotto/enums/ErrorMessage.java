package lotto.enums;

public enum ErrorMessage {
    ERROR_MESSAGE_PREFIX("[ERROR] "),

    // 구매 금액 검증
    INVALID_NUMBER_FORM("숫자만 입력할 수 있습니다."),
    NOT_DIVISIBLE_BY_THOUSAND("1000으로 나눌 수 있는 1000 이상의 숫자만 입력할 수 있습니다."),

    // 로또 번호 검증
    INVALID_NUMBERS_INPUT("쉼표 구분의 숫자 목록만 입력할 수 있습니다."),
    NOT_IN_BOUNDARY("1~45 사이의 숫자만 입력할 수 있습니다."),
    DUPLICATED_NUMBERS("중복 없는 숫자들을 입력해야 합니다."),
    INVALID_NUMBERS_COUNT("로또 번호는 6개여야 합니다."),

    // 보너스 번호 검증
    DUPLICATED_WITH_WINNING_NUMBERS("당첨 번호와 중복되지 않은 숫자를 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format() {
        return ERROR_MESSAGE_PREFIX.getMessage() + message;
    }
}
