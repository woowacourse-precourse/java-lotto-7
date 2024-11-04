package lotto.exception;

public enum ErrorCode {

    FAILED_TO_PARSE_INTEGER("입력값을 정수(int)로 변환할 수 없습니다"),
    PURCHASE_AMOUNT_MUST_BE_POSITIVE("구매 금액은 양수로만 입력 가능합니다"),
    PURCHASE_AMOUNT_SHOULD_BE_MULTIPLE_OF_1000("구매 금액은 1000 단위로 입력해 주세요"),

    LOTTO_NUMBER_COUNT_MUST_BE_SIX("로또 번호는 반드시 6개여야 합니다"),

    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1에서 45 사이의 숫자여야 합니다"),

    DUPLICATE_LOTTO_NUMBERS_NOT_ALLOWED("로또 번호에 중복된 숫자가 포함될 수 없습니다"),

    NO_MATCHING_STATE("일치하는 상태가 없습니다");

    private final String message;
    private final String ERROR_PREFIX = "[ERROR] ";

    ErrorCode(final String message){
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage(){
        return this.message;
    }
}
