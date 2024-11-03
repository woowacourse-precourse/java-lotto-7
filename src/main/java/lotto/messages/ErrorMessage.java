package lotto.messages;

public enum ErrorMessage {
    DUPLICATE_WINNING_NUMBERS("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    BONUS_NUMBER_NOT_NUMBER("[ERROR] 보너스 번호는 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATION("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다"),
    WINNING_NUMBER_DUPLICATION("[ERROR] 당첨 번호는 당첨 번호와 중복될 수 없습니다"),
    INVALID_LOTTO_PRICE("[ERROR] 로또 금액은 천원 단위로 입력할 수 있습니다."),
    PRICE_NOT_NUMBER("[ERROR] 숫자만 입력할 수 있습니다.");



    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
