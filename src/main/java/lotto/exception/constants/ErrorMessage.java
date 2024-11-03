package lotto.exception.constants;

public enum ErrorMessage {

    LOTTO_NUMBER_SIZE_NOT_MATCH("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_DUPLICATE("로또 번호에 중복된 번호가 존재합니다."),
    WINNING_NUMBER_DUPLICATE("당첨 번호에 중복된 번호가 존재합니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_PURCHASE_MONEY_LESS_THAN_1000("구입 금액이 1,000원보다 작을 수 없습니다."),
    LOTTO_PURCHASE_MONEY_UNIT_NOT_1000("구입 금액을 1,000원 단위로 입력해주시길 바랍니다."),
    INVALID_INPUT_TEXT("잘못된 입력 값입니다."),
    INVALID_NUMBER("잘못된 번호 값입니다."),
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(final String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
