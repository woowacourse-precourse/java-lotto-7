package lotto.exception;

public enum ErrorMessage {
    // 입력
    INPUT_EMPTY_ERROR("빈 입력입니다."),
    END_WITH_DELIMITER("입력은 구분자(%s)로 끝날 수 없습니다."),

    // 구입 금액
    MONEY_NOT_DIVISIBLE("구입 금액은 %d원으로 나누어 떨어져야 합니다."),
    MONEY_NOT_NUMBER("구입 금액은 숫자여야 합니다."),
    MONEY_OUT_OF_RANGE("구입 금액은 %d이상의 정수여야 합니다."),

    // 당첨 번호
    WINNING_NUMBER_NOT_DIGIT("당첨 번호는 숫자여야 합니다."),
    WINNING_NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER("중복된 번호가 있습니다."),
    NUMBERS_SIZE_ERROR("로또 번호는 %d개여야 합니다."),

    // 보너스 번호
    BONUS_NUMBER_NOT_DIGIT("보너스 번호는 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE("당첨 번호와 중복된 번호입니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
