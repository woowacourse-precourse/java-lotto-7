package lotto.exception;

public enum ExceptionMessage {
    ERROR_NOT_DIVISIBLE_BY_1000("[ERROR] 로또는 천원 단위로 구매할 수 있습니다."),
    ERROR_NOT_INTEGER("[ERROR] 숫자를 입력해주세요."),
    ERROR_NEGATIVE_NUMBER("[ERROR] 자연수를 입력해주세요."),
    ERROR_NOT_IN_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_LOTTO_SIZE_NOT_MATCHED("[ERROR] 로또 번호는 6개여야 합니다."),
    ERROR_DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
