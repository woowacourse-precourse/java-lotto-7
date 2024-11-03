package lotto.util;

public enum ErrorResponse {
    INVALID_MONEY("[ERROR] 구입 금액은 숫자이어야 합니다."),
    INVALID_MONEY_BOUND("[ERROR] 구입 금액은 1000원 이상이어야 합니다."),
    INVALID_MONEY_UNIT("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
    INVALID_LOTTO_COUNT("[ERROR] 로또 개수는 6개이어야 합니다."),
    INVALID_LOTTO_NUM_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_LOTTO_NUMBER("[ERROR] 로또 번호는 1부터 45까지의 숫자여야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 1부터 45까지의 숫자여야 합니다."),
    INVALID_BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    ;

    private final String message;

    ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
