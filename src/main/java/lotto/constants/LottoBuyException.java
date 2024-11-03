package lotto.constants;

public enum LottoBuyException {
    INVALID_POSITIVE_INPUT("양의 정수 입력이 아닙니다."),
    NEGATIVE_NUMBER_NOT_ALLOWED("음수는 입력할 수 없습니다."),
    INVALID_AMOUNT_MULTIPLE("금액은 천의 배수 단위로 입력하세요.");

    private final String message;

    LottoBuyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
