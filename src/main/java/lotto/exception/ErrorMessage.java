package lotto.exception;

public enum ErrorMessage {
    PURCHASE_AMOUNT_MUST_BE_NUMBER("[ERROR] 구매금액은 숫자여야 합니다."),
    PURCHASE_AMOUNT_MUST_BE_AT_LEAST_1000("[ERROR] 구매금액은 1,000원 이상이어야 합니다."),
    PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000("[ERROR] 구매금액은 1,000원 단위여야 합니다."),
    PURCHASE_AMOUNT_TOO_LARGE("[ERROR] 로또 구입 금액이 너무 큽니다."),
    LOTTO_NUMBERS_MUST_BE_SIX("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_MUST_BE_BETWEEN_1_AND_45("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBERS_MUST_NOT_DUPLICATE("[ERROR] 로또 번호는 중복을 허용하지 않습니다."),
    BONUS_NUMBER_MUST_BE_BETWEEN_1_AND_45("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATES_WITH_WINNING_NUMBERS("[ERROR] 보너스 번호와 당첨 번호가 중복됩니다."),
    NULL_INPUT_ERROR("[ERROR] null은 입력할 수 없습니다."),
    EMPTY_INPUT_ERROR("[ERROR] 빈 문자열은 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
