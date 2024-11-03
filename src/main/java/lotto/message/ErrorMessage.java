package lotto.message;

public enum ErrorMessage {
    PURCHASE_AMOUNT_INVALID("구입 금액은 1000원 단위부터 시작합니다."),
    INPUT_NOT_NUMERIC("입력은 숫자만 가능합니다."),
    WINNING_NUMBERS_FORMAT_INVALID("로또 번호는 숫자와 콤마(,)로 구성되어야 합니다."),
    WINNING_NUMBERS_SIZE_INVALID("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_RANGE_INVALID("로또 번호는 1부터 45 사이여야 합니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호는 로또 번호와 중복될 수 없습니다."),
    DUPLICATE_NUMBER("번호 중에 중복 번호가 있습니다."),
    ;
    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
