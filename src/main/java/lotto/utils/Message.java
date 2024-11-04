package lotto.utils;

public enum Message {
    DEFAULT_HEADER("[ERROR] "),
    INVALID_NUMBERS_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_NUMBERS_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_DUPLICATES_NUMBER("로또 번호에는 중복된 숫자가 있을 수 없습니다."),
    INVALID_DUPLICATE_WINNING_NUMBERS("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_1000_MULTIPLE("구매 금액은 1000 단위로 입력해야 합니다."),
    INVALID_INPUT_TYPE("잘못된 입력 형식입니다."),
    INVALID_DELIMITER("잘못된 구분자 입니다."),
    REGEX_MATCH_PATTERN("^(?:(?:[1-9]|[1-3][0-9]|4[0-5]),){5}(?:[1-9]|[1-3][0-9]|4[0-5])$");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
