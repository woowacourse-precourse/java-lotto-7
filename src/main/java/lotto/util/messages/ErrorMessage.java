package lotto.util.messages;

public enum ErrorMessage {
    PRICE_IS_NOT_NUMBER("[ERROR] 구입금액은 정수여야 합니다."),
    PRICE_IS_UNDER_1000("[ERROR] 구입금액은 1000원 이상이어야 합니다."),
    NUMBER_COUNT_NOT_SIX("[ERROR] 로또 번호는 6개여야 합니다."),
    NUMBER_OVER_RANGE("[ERROR] 로또 번호는 1~45사이의 숫자여야 합니다."),
    NUMBER_IS_NOT_INTEGER("[ERROR] 로또 번호는 정수여야 합니다."),
    NUMBER_IS_DUPLICATED("[ERROR] 로또 번호는 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
