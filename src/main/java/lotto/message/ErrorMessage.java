package lotto.message;

public enum ErrorMessage {
    INVALID_PURCHASE_PRICE("[ERROR] 구입금액은 1,000원 단위의 숫자만 허용됩니다."),
    INVALID_WINNING_NUMBERS("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.(쉼표(,)로 구분)"),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_LOTTO("[ERROR] 로또 번호는 1에서 45 사이의 숫자 6개여야 합니다."),
    DUPLICATE_LOTTO("[ERROR] 로또 번호는 중복되지 않은 숫자 6개여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
