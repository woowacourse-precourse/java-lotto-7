package lotto.constant;

public enum ErrorMessage {
    LOTTO_COUNT_SHOULD_BE_SIX_VALIDATOR("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE_VALIDATOR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_DUPLICATE_VALIDATOR("[ERROR] 로또 번호는 중복될 수 없습니다."),
    BONUS_NUMBER_RANGE_VALIDATOR("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    IS_PAYMENT_OVER_MAX_LIMIT_VALIDATOR("[ERROR] 로또는 최대 10만원까지 구매 가능합니다."),
    IS_PAYMENT_DIVISION_BY_LOTTO_PRICE_VALIDATOR("[ERROR] 로또를 구매하기 위해서 1000원 단위로 돈을 넣어 주세요."),
    BONUS_NUMBER_DUPLICATE_VALIDATOR("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다."),
    BONUS_NUMBER_NUMERIC_VALIDATOR("[ERROR] 보너스 번호는 숫자여야합니다."),
    BONUS_NUMBER_NOT_NULL_VALIDATOR("[ERROR] 보너스 번호가 입력되지 않았습니다."),
    MONEY_NOT_NULL_VALIDATOR("[ERROR] 로또를 구매하려는 금액을 입력해 주세요."),
    MONEY_NUMERIC_VALIDATOR("[ERROR] 로또를 구매하려는 금액을 숫자로 입력해 주세요."),
    WINNING_NUMBERS_NOT_NULL_VALIDATOR("[ERROR] 로또 번호가 입력되지 않았습니다."),
    WINNING_NUMBERS_NUMERIC_VALIDATOR("[ERROR] 로또 번호는 숫자여야합니다."),
    ;

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
