package lotto.constant;

public enum ErrorMessage {
    DEFAULT_MESSAGE("[ERROR]"),
    LOTTO_REGEX_PATTERN(DEFAULT_MESSAGE.message + " 형식에 맞지 않는 입력값 ex)1,2,3,4,5,6 형식으로 입력해주세요."),
    NUMBER_REGEX_PATTERN(DEFAULT_MESSAGE.message + " 형식에 맞지 않는 입력값 양의 정수만 입력해주세요."),
    AMOUNT_LIMIT(DEFAULT_MESSAGE.message + " 금액은 10만원 이하로 입력해주세요."),
    DIVISIBLE_BY_THOUSAND(DEFAULT_MESSAGE.message + " 천원으로 나눠지게 입력해주세요"),
    WITHIN_RANGE(DEFAULT_MESSAGE.message + " 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE(DEFAULT_MESSAGE.message + " 중복된 번호가 있습니다."),
    NUMBER_COUNT(DEFAULT_MESSAGE.message + " 로또 번호는 6개여야 합니다.");
    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void throwIllegalArgumentException() {
        throw new IllegalArgumentException(message);
    }
}