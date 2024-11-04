package lotto.utils;

public enum ErrorMessages {
    NUMBER_PARSE_ERROR("숫자로 입력해야 합니다."),
    SPLIT_NUMBER_ERROR("쉼표(,)로 구분된 숫자를 입력해야 합니다."),
    PURCHASE_AMOUNT_LESS_THAN_ZERO("구입 금액은 0보다 작을 수 없습니다."),
    PURCHASE_AMOUNT_NOT_MINIMUM_UNIT("구입 금액은 1000원 단위로 입력해야 합니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATED("로또 번호는 중복되지 않아야 합니다."),
    LOTTO_NUMBER_SIZE("로또 번호는 6개여야 합니다."),
    BONUS_NUMBER_DUPLICATED("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessages(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
