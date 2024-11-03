package lotto.exception.winning;


public enum WinningNumbersErrorMessages {
    INVALID_SIZE("[ERROR] 당첨 번호는 6개여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    OUT_OF_RANGE_NUMBER("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_EMPTY("[ERROR] 문자열이 비어있으면 안 됩니다."),
    INVALID_CHARACTER("[ERROR] 당첨 번호는 숫자여야 합니다."),
    INVALID_WHITESPACE("[ERROR] 당첨 번호에 공백이 없어야 합니다.")
    ;

    private final String message;

    WinningNumbersErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
