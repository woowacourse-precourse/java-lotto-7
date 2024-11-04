package lotto.config;

public enum ErrorMessage {
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    INVALID_CONTAIN_BLANK("[ERROR] 공백을 포함할 수 없습니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 숫자 형식이 올바르지 않습니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_DELIMITER_FORMAT("[ERROR] 쉼표(,)로 구분된 형식이 올바르지 않습니다.");

    String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}