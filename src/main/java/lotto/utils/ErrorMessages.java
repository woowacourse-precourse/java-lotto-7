package lotto.utils;

public enum ErrorMessages {
    ERROR_MINIMUM_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 이상의 금액이어야 합니다."),
    ERROR_INVALID_AMOUNT_UNIT("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    ERROR_INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    ERROR_DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호에 중복된 값이 입력되었습니다."),
    ERROR_DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호에 중복된 값이 입력되었습니다."),
    NUMERIC_INPUT_ONLY_MESSAGE("[ERROR] 구입 금액은 숫자로만 입력해야 합니다.");
    private String error;

    ErrorMessages(String error) {
        this.error = error;
    }

    public String getMessage() {
        return error;
    }
}
