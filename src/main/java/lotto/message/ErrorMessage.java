package lotto.message;

public enum ErrorMessage {

    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO("로또 번호는 중복이 될 수 없습니다."),
    EXCLUDE_LOTTO_RANGE("로또 번호는 1 ~ 45 범위내의 숫자이여야 합니다."),
    EXCLUDE_BONUS_RANGE("보너스 번호는 1 ~ 45 범위내의 숫자이여야 합니다."),
    EQUALS_LOTTO_BONUS("로또 번호와 보너스 번호가 같을 수 없습니다."),

    INVALID_PURCHASE_MONEY("구매금액은 1000원 단위여야 합니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format("[ERROR] %s", message);
    }
}
