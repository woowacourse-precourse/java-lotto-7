package lotto.enums;

public enum ErrorMessage {
    INTEGER_PARSE_FAIL("올바른 숫자를 입력해 주세요."),
    INVALID_PURCHASE_AMOUNT("구입 금액은 1000원 단위로 입력해야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("당첨 번호의 범위는 1부터 45까지 입니다."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호의 범위는 1부터 45까지 입니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER("잘못된 당첨 번호 입니다."),
    LOTTO_NUMBER_DUPLICATE("당첨 번호에 중복된 번호가 있습니다."),
    LOTTO_BONUS_NUMBER_DUPLICATE("보너스 번호에 중복된 번호가 있습니다.");

    private static final String ERROR_FORMAT = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_FORMAT + message;
    }

}
