package lotto.enumMessage;

public enum ErrorMessage {
    INVALID_VALUE("[ERROR] 숫자를 입력하세요."),
    USER_LOTTO_PRICE("[ERROR] 로또 한 장 가격은 1000원 입니다. 올바른 금액을 입력해주세요."),
    LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_OUT_OF_RANGE("[ERROR] 로또 번호는 1~45사이의 숫자여야 합니다."),
    LOTTO_DUPLICATE("[ERROR] 로또 번호는 중복되면 안됩니다."),
    BONUS_OUT_OF_RANGE("[ERROR] 보너스 번호는 1~45사이의 숫자여야 합니다."),
    BONUS_DUPLICATE("[ERROR] 보너스 번호는 로또 번호와 중복되면 안됩니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
