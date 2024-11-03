package lotto.util;

public enum ErrorMessage {
    INVALID_INPUT("[ERROR] 입력이 잘못되었습니다."),
    INVALID_NUMBER("[ERROR] 숫자만 입력해야 합니다."),
    INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER("[ERROR] 로또 번호가 1~45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_MONEY("[ERROR] 금액은 1000원 이상이어야 합니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
