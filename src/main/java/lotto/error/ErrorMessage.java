package lotto.error;

public enum ErrorMessage {

    INVALID_EMPTY_INPUT("입력된 값이 NULL이어서는 안됩니다."),
    POSITIVE_REQUIRED("입력된 값은 양수이어야 합니다."),
    NUMBER_OUT_OF_RANGE("입력 번호는 %d부터 %d까지 가능합니다."),
    INVALID_ZERO_AMOUNT("구입금액은 0일 수 없습니다."),
    INVALID_AMOUNT("구입금액은 로또 금액의 배수여야 합니다."),
    INVALID_NUMBER_COUNT("로또 번호는 %d개여야 합니다."),
    DUPLICATE_NUMBER("로또 번호는 중복될 수 없습니다 ."),
    DUPLICATE_BONUS("보너스 번호는 로또 번호와 중복될 수 없습니다.");

    private static final String PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
