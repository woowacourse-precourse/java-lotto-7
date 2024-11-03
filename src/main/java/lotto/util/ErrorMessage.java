package lotto.util;

public enum ErrorMessage {
    INVALID_PURCHASE_AMOUNT_ERROR("올바른 금액을 입력해 주세요."),
    NUMBER_FORMAT_ERROR("입력값은 숫자여야 합니다."),
    NEGATIVE_OR_ZERO_AMOUNT_ERROR("금액은 0보다 커야 합니다."),
    NOT_THOUSAND_UNIT_ERROR("금액은 1,000원 단위로 입력해 주세요."),
    INVALID_NUMBER_INPUT_ERROR("당첨 번호로 유효하지 않은 값이 입력되었습니다."),
    NUMBER_OUT_OF_RANGE_ERROR("로또 번호는 1과 45 사이여야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT_ERROR("로또는 6개의 숫자로 구성되어야 합니다."),
    DUPLICATE_LOTTO_NUMBER_ERROR("중복되는 번호가 존재합니다."),
    DUPLICATED_BONUS_NUMBER_ERROR("보너스 번호가 당첨 번호와 겹칩니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NEW_LINE = "\n";

    public final String message;

     ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message + NEW_LINE;
    }
}
