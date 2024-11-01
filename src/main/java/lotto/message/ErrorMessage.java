package lotto.message;

public enum ErrorMessage {
    INVALID_LOTTO_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_DUPLICATE_LOTTO("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_DUPLICATE_BONUS("[ERROR] 당첨 번호와 중복되지 않은 보너스 번호를 입력해주세요."),
    INVALID_LOTTO_LENGTH("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_NATURAL_AMOUNT("[ERROR] 로또 구매 금액은 1000원 단위의 자연수여야 합니다."),
    INVALID_WRONG_DELIMITER("[ERROR] 자연수와 , 만 입력값으로 받을 수 있습니다.");

    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}