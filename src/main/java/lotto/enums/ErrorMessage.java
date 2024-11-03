package lotto.enums;

public enum ErrorMessage {
    INVALID_AMOUNT("금액은 " + LottoConstants.LOTTO_PRICE.getValue() + "원 단위로 입력해야 합니다."),
    INVALID_WINNING_NUMBERS_COUNT("로또 번호는 " + LottoConstants.LOTTO_NUMBERS_COUNT.getValue() + "개여야 합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 " + LottoConstants.MIN_LOTTO_NUMBER.getValue() + "부터 "
            + LottoConstants.MAX_LOTTO_NUMBER.getValue() + " 사이의 숫자여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),
    INVALID_WINNING_NUMBERS_RANGE("로또 번호는 " + LottoConstants.MIN_LOTTO_NUMBER.getValue() + "부터 "
            + LottoConstants.MAX_LOTTO_NUMBER.getValue() + " 사이의 숫자여야 합니다."),
    INVALID_INTEGER("정수를 입력해야 합니다.");



    private static final String ERROR_TAG = "[ERROR]";
    private static final String ERROR_SEPARATOR = " ";  // 태그 뒤 공백
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TAG + ERROR_SEPARATOR + message;
    }

    public String format(Object... args) {
        return ERROR_TAG + ERROR_SEPARATOR + String.format(message, args);
    }
}
