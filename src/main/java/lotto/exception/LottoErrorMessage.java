package lotto.exception;

public enum LottoErrorMessage {
    OUT_OF_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1부터 45까지의 숫자여야 합니다."),
    BONUS_NUMBER_SAME_AS_WINNING_NUMBER("[ERROR] 보너스 번호는 로또 당첨 번호와 중복되지 않는 번호를 입력해야 합니다."),
    INPUT_IS_EMPTY("[ERROR] 입력 값이 비어있습니다."),
    INPUT_CONTAINS_WHITE_SPACE("[ERROR] 입력 값에 공백이 포함되어 있습니다."),
    OUT_OF_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45까지의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATION("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    MONEY_LESS_THAN_THOUSAND("[ERROR] 구입 금액은 1000원 이상으로만 입력해야 합니다."),
    MONEY_NOT_DIVISIBLE_BY_THOUSAND("[ERROR] 구입 금액은 1000원 단위로만 입력 가능 합니다."),
    INPUT_IS_NOT_NUMERIC("[ERROR] 입력값이 숫자 형태가 아닙니다."),
    INVALID_NUMBER_RANGE("[ERROR] 숫자는 최대 2,147,483,647까지만 입력 가능합니다.");
    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
