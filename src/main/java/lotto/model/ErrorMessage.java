package lotto.model;

public enum ErrorMessage {

    EMPTY_INPUT("[ERROR] 아무것도 입력되지 않았습니다."),
    NEGATIVE_INPUT("[ERROR] 구입 금액은 양수여야 합니다."),
    MULTIPLE_INPUT("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    EMPTY_WINNING_INPUT("[ERROR] 당첨 번호가 입력되지 않았습니다."),
    INVALID_COUNT("[ERROR] 당첨 번호는 6개여야 합니다."),
    DUPLICATE_WINNING_NUMBERS("[ERROR] 당첨 번호에 중복이 있을 수 없습니다."),
    INVALID_WINNING_NUMBER("[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
