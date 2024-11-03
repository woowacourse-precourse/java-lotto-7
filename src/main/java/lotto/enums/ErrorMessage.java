package lotto.enums;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),  // 에러 접두사 상수
    PURCHASE_EMPTY_INPUT("금액을 입력해 주세요."),
    PURCHASE_INVALID_NUMBER_FORMAT("유효한 숫자를 입력해 주세요."),
    PURCHASE_MIN_PRICE("최소 구입 금액은 1000원 이상이어야 합니다."),
    PURCHASE_MAX_PRICE("최대 구입 금액은 100000원을 초과할 수 없습니다."),
    PURCHASE_INVALID_DIVISIBILITY("구입 금액은 1000원 단위여야 합니다."),
    LOTTO_INVALID_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE_NUMBER("로또 번호는 중복될 수 없습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }
}

