package lotto.enums;

public enum ErrorMessage {
    NOT_NUMBER("숫자가 아닙니다."),
    INVALID_RANGE("범위가 유효하지 않습니다."),
    NOT_DIVISIBLE_BY_THOUSAND("천원 단위로 나누어 지지 않습니다."),
    EMPTY_INPUT("빈 입력입니다."),
    INVALID_WINNING_NUMBER_COUNT("당첨 번호 개수가 맞지 않습니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("번호는 중복될 수 없습니다."),
    DUPLICATE_WINNING_NUMBER("보너스 번호는 당첨번호와 중복될 수 없습니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}