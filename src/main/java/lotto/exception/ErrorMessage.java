package lotto.exception;

public enum ErrorMessage {
    // 로또 관련 예외 메시지
    INVALID_LOTTO_COUNTS("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    INVALID_LOTTO_RANGE("로또 번호는 1에서 45사이의 숫자여야합니다."),
    // 구매액 관련 예외 메시지
    INVALID_PURCHASE_TYPE("구매 금액은 숫자로만 입력해주세요."),
    INVALID_PURCHASE_AMOUNT_UNIT("구매 금액은 1000원 단위만 가능합니다."),
    INVALID_PURCHASE_MIN("구매 금액은 1000원 이상이여야합니다."),
    INVALID_PURCHASE_COUNT("로또는 1개 이상 구매해야합니다."),
    // 보너스 숫자 예외 메시지
    INVALID_BONUS_NUMBER_RANGE("보너스 숫자는 1에서 45사이의 숫자여야합니다."),
    INVALID_BONUS_NUMBER_TYPE("보너스 숫자는 숫자만 입력 가능합니다."),
    INVALID_BONUS_NUMBER_DUPLICATE("보너스 숫자는 당첨 숫자와 달라야합니다."),
    // 당첨 숫자 예외 메시지
    INVALID_WINNER_NUMBER_TYPE("당첨 숫자를 쉼표(,)를 기준으로 구분하여 입력해야합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    public String getMessage() {
        return this.message;
    }

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }
}
