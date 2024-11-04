package lotto.exception;

public enum LottoExceptionType {
    EMPTY_INPUT_WINNING_NUMBER("[ERROR] 당첨 번호를 입력해주세요. 당첨 번호는 1부터 45 사이의 중복되지 않는 6개의 숫자입니다."),
    WRONG_FORMAT_WINNING_NUMBER("[ERROR] 당첨 번호는 쉼표로 구분한 6개의 숫자여야 합니다."),
    OUT_OF_RANGE_WINNING_NUMBER("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_WINNING_NUMBER("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    NOT_INTEGER_WINNING_NUMBER("[ERROR] 당첨 번호는 정수로 입력해주세요.");

    private final String message;

    LottoExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
