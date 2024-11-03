package lotto.constants;

public enum LottoBuyException {
    INVALID_POSITIVE_INPUT("[ERROR] 문자, 소수, 2^31-1 이상의 정수는 입력 불가합니다."),
    NEGATIVE_NUMBER_NOT_ALLOWED("[ERROR] 음수는 입력할 수 없습니다."),
    INVALID_AMOUNT_MULTIPLE("[ERROR] 금액은 천의 배수 단위로 입력하세요.");

    private final String message;

    LottoBuyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
