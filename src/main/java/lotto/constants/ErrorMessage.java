package lotto.constants;

public enum ErrorMessage {
    INPUT_LOTTO_NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호가 숫자 범위를 벗어납니다."),
    CANT_DUPLICATED_BONUS_NUMBER_WITH_WINNING_NUMBER("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다."),
    LOTTO_SIZE_MUST_BE_SIX("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATED_IN_LOTTO_NUMBERS("[ERROR] 로또 번호에 중복이 존재합니다."),
    PUT_VALID_LOTTO_NUMBERS("[ERROR] 유효한 당첨 번호를 입력해주세요."),
    PUT_VALID_BONUS_NUMBER("[ERROR] 유효한 보너스 번호를 입력해주세요."),
    PURCAHSE_PRICE_MUST_BE_NATURAL_NUMBER("[ERROR] 구입 금액이 자연수가 아닙니다."),
    IS_NOT_DIVISIBLE_BY_THOUSAND_WON("[ERROR] 1000원으로 나누어떨어지지 않습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
