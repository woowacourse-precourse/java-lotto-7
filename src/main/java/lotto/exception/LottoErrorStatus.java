package lotto.exception;

public enum LottoErrorStatus {
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호의 범위는 1부터 45입니다."),
    LOTTO_NUMBER_DUPLICATED("로또 번호는 중복될 수 없습니다."),

    INVALID_LOTTO_FORMAT("로또 번호는 \",\"로 구분된 정수여야 합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 정수여야 합니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),

    EMPTY_USER_INPUT("입력값이 비어 있습니다."),
    INVALID_BUDGET_FORMAT("구매 금액에는 숫자만 포함될 수 있습니다."),
    INVALID_BUDGET_AMOUNT("구입 금액은 정수 형태여야 합니다."),
    INVALID_BUDGET_UNIT("1000원 단위로 로또를 구매할 수 있습니다.");

    private final String message;

    LottoErrorStatus(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
