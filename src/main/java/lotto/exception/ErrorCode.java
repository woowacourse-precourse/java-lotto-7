package lotto.exception;

public enum ErrorCode {

    NOT_POSITIVE_INTEGER("[ERROR] 구매 금액은 양수만 입력 가능합니다."),
    NOT_DIVISIBLE_BY_THOUSAND("[ERROR] 구매 금액은 천 단위의 양수만 입력 가능합니다."),
    INVALID_WINNING_NUMBER_FORMAT("[ERROR] 당첨 번호 형식이 올바르지 않습니다."),
    INVALID_BONUS_NUMBER_FORMAT("[ERROR] 보너스 번호 형식이 올바르지 않습니다."),
    DUPLICATE_NUMBER("[ERROR] 이미 존재하는 당첨 번호입니다."),
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복된 값을 가질 수 없습니다.");

    private final String message; // TODO 커스텀 예외 추가

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
