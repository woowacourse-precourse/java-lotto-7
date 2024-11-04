package lotto.exception;

public enum ExceptionMessage {
    EMPTY_INPUT("[ERROR] 공백이나 빈 문자열은 허용하지 않습니다."),
    NON_NUMERIC_INPUT("[ERROR] 숫자가 아닌 문자가 포함되어 있습니다."),
    INVALID_AMOUNT_UNIT("[ERROR] 금액은 1,0000원 단위여야 합니다."),
    ONLY_POSITIVE_INPUT("[ERROR] 입력은 양의 정수여야 합니다."),
    POSITIVE_SIGN_INPUT("[ERROR] 양의 부호를 포함할 수 없습니다."),
    INVALID_COMMA_POSITION("[ERROR] 입력 값의 맨 앞이나 맨 뒤에 쉼표가 올 수 없습니다."),
    OUT_OF_RANGE_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_WITH_WINNING_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    LOTTO_COUNT_LIMIT("[ERROR] 로또 개수는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    EXCEEDS_MAX_AMOUNT("[ERROR] 최대 구입 금액을 초과했습니다. 최대 금액은 %,d원입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessageWithMaxAmount(long maxAmount){
        return String.format(this.message, maxAmount);
    }
}
