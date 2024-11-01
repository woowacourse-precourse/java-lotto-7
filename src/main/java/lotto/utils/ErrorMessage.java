package lotto.utils;

public enum ErrorMessage {
    INVALID_NUMBER("[ERROR] 숫자만 입력할 수 있습니다."),
    PURCHASE_AMOUNT_TOO_LOW("[ERROR] 1000 이상의 금액을 입력해야 합니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER_WITH_WINNING("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
