package lotto.constants;


public enum ErrorMessage {
    NULL_OR_EMPTY_INPUT("입력값이 비어있습니다."),
    PURCHASE_AMOUNT_MUST_BE_NUMBER("로또 구입 금액은 숫자여야 합니다."),
    PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_THOUSAND("로또 구입 금액은 1,000원 단위여야 합니다."),
    WINNING_NUMBER_MUST_BE_NUMBER("당첨 번호는 숫자여야 합니다."),
    NUMBER_MUST_BE_IN_RANGE("숫자 범위는 1~45 사이여야 합니다."),
    WINNING_NUMBER_COUNT_MESSAGE("당첨 번호는 6자이어야 합니다"),
    BONUS_NUMBER_MUST_BE_NUMBER("보너스 번호는 숫자여야 합니다."),
    DUPLICATE_NUMBER("중복된 숫자 입니다.");

    private final String message;
    private static final String PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
