package lotto.exception.lotto;

public enum LottoErrorMessages {
    INVALID_AMOUNT_NON_EMPTY("[ERROR] 로또 구입 금액은 공백이 불가능합니다."),
    INVALID_AMOUNT_NON_NUMERIC("[ERROR] 로또 구입 금액은 숫자만 입력 가능합니다."),
    INVALID_AMOUNT_NON_POSITIVE("[ERROR] 로또 구입 금액은 양수만 입력 가능합니다."),
    INVALID_AMOUNT_NOT_DIVISIBLE_BY_1000("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다."),
    INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    OUT_OF_RANGE_LOTTO_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    ;

    private final String message;

    LottoErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
