package lotto.utils;

public enum Message {
    DEFAULT_HEADER("[ERROR] "),
    INVALID_NUMBERS_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_NUMBERS_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_DUPLICATES_NUMBER("로또 번호에는 중복된 숫자가 있을 수 없습니다."),
    INVALID_DUPLICATE_WINNING_NUMBERS("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
