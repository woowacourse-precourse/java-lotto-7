package lotto.exception;

public enum ErrorMessages {

    INVALID_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복되면 안됩니다."),
    INVALID_BONUS_NUMBER_TYPE("보너스 번호는 숫자여야 합니다."),
    INVALID_LOTTO_RANGE("번호는 1부터 45 사이여야 합니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_PRICE("로또 구입 금액은 1000원 이상이어야 합니다."),
    INVALID_LOTTO_PRICE_DIVISIBLE("로또 구입 금액은 1000원으로 나누어 떨어져야 합니다."),
    INVALID_LOTTO_PRICE_TYPE("문자나 음수는 입력할 수 없습니다."),
    INVALID_LOTTO_DUPLICATE("중복된 숫자가 있습니다.");

    private String message = "[ERROR] ";

    ErrorMessages(String message) {
        this.message += message;
    }

    public String getMessage() {
        return message;
    }

}
