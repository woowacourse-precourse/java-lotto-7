package lotto.enums;

public enum Error {
    INVALID_PRICE_INPUT("[ERROR] 구입금액은 1000의 배수인 양의 정수를 입력해야 합니다."),
    INVALID_LOTTO_NUMBER("[ERROR] 당첨 번호는 중복되지 않는 6개의 정수여야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 한가지 수여야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
