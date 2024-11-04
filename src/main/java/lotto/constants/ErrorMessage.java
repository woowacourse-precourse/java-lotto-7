package lotto.constants;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR]"),

    INVALID_AMOUNT("구입 금액은 %d원 단위여야 합니다."),
    POSITIVE_AMOUNT_REQUIRED("구입 금액은 양수여야 합니다."),
    INTEGER_AMOUNT_REQUIRED("구입 금액은 숫자여야 합니다."),

    EMPTY_INPUT("입력값이 비어 있습니다. 값을 입력해 주세요."),

    DUPLICATE_WINNING_NUMBER("당첨 번호에 중복된 숫자가 있습니다."),
    INVALID_WINNING_NUMBER_COUNT("당첨 번호는 %d개여야 합니다."),

    DUPLICATE_LOTTO_NUMBER("로또 번호에 중복된 숫자가 있습니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 %d개여야 합니다."),

    DUPLICATE_BONUS_NUMBER("보너스 번호가 당첨 번호와 중복됩니다."),
    INVALID_BONUS_NUMBER_COUNT("보너스 번호는 1개여야 합니다."),

    NUMBER_NOT_INTEGER("번호는 숫자여야 합니다."),
    OUT_OF_BOUNDS("번호는 %d부터 %d 사이여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + " " + message + "\n\n";
    }
}
