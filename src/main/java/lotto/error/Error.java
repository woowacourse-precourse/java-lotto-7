package lotto.error;

public enum Error {
    NOT_IN_1000_UNITS("[ERROR] 1000원 단위로 입력해 주세요."),
    INVALID_LOTTO_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    NOT_A_NUMBER("[ERROR] 숫자를 입력해 주세요."),
    OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다."),
    DUPLICATE_WITH_WINNING_NUMBERS("[ERROR] 입력한 당첨 번호와 중복되지 않는 숫자를 입력해주세요");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
