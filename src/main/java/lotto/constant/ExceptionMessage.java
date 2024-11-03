package lotto.constant;

public enum ExceptionMessage {
    DUPLICATE_BONUS_BALL("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_BONUS_BALL_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_INPUT("[ERROR] 숫자만 입력 가능합니다."),
    INVALID_LOTTO_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_PURCHASE_UNIT("[ERROR] 로또 구입 금액은 천 원 단위여야 합니다."),
    IS_NOT_POSITIVE("[ERROR] 로또 구입 금액은 0보다 커야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
