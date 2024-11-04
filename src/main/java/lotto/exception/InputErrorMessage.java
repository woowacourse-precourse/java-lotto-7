package lotto.exception;

public enum InputErrorMessage {

    //문자열 -> 숫자 파싱 관련 메시지
    INVALID_NUMERIC_FORMAT("[ERROR] 입력값은 숫자여야 합니다."),  // 구입 금액, 당첨 번호, 보너스 번호에 공통 사용 가능,
    OVER_NUMERIC_FORTMAT("[ERROR] 정수의 최대값을 입력할 수 없습니다."),
    EMPTY_INPUT("[ERROR] 입력은 비어있을 수 없습니다."),

    // 구입 금액 관련 메시지,
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    NEGATIVE_OR_ZERO_AMOUNT("[ERROR] 구입 금액은 1,000원 이상이어야 합니다."),
    EXCEEDS_LIMIT_AMOUNT("[ERROR] 구입 금액은 1,000,000원을 초과할 수 없습니다."),

    // 당첨 번호 관련 메시지
    INVALID_WINNING_RANGE("[ERROR] 당첨 번호는 1~45 범위의 양의 정수여야 합니다."),
    DUPLICATED_WINNING_NUMBER("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    OVER_SIZE_WINNING_NUMBER("[ERROR] 당첨 번호는 6자리여야 합니다."),

    // 보너스 번호 관련 메시지
    INVALID_BONUS_RANGE("[ERROR] 보너스 번호는 1~45 범위의 양의 정수여야 합니다."),
    DUPLICATED_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
