package lotto.util;

public enum ErrorMessages {
    INVALID_AMOUNT_FORMAT("[ERROR] 구입 금액은 숫자여야 합니다."),
    INVALID_AMOUNT_UNIT("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    EMPTY_LOTTO_TICKET_LIST ("리스트는 비어있을 수 없습니다."),
    INVALID_WINNING_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_WINNING_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_WINNING_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_NUMBER_INPUT("[ERROR] 입력값은 숫자여야 합니다.");
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
