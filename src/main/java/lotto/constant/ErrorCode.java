package lotto.constant;

public enum ErrorCode {
    // MONEY
    INVALID_MONEY("구입 금액은 숫자를 입력해주세요."),
    NOT_POSITIVE_MONEY("구입 금액은 양수를 입력해주세요."),
    DIVISION_BY_LOTTO_PRICE("구입 금액은 1000원 단위여야 합니다."),

    // Lotto
    INVALID_LOTTO_NUMBER("로또 번호는 숫자를 입력해야 합니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개를 입력해야 합니다."),
    OUT_OF_RANGE_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),

    // Bonus Number
    INVALID_BONUS_NUMBER("보너스 번호는 숫자를 입력해야 합니다."),
    OUT_OF_RANGE_BONUS_NUMBER("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복일 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR]";
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + " " + message;
    }
}
