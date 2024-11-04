package lotto.util;

public enum ErrorMessage {
    EMPTY_INPUT("입력값이 비어 있습니다."),
    NON_NUMBER("int 범위의 정수값으로 입력해야 합니다."),
    NON_POSITIVE_NUMBER("양수값으로 입력해야 합니다."),
    NON_DIVISIBLE_BY_THOUSAND("구입 금액은 1,000 단위여야 합니다."),
    LOTTO_NUMBERS_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATE_WINNING_NUMBERS("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_DUPLICATE_WINNING_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private static final String ERROR_START = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_START + message;
    }
}