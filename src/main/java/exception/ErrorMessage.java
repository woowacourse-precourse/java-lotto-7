package exception;

public enum ErrorMessage {

    LOTTO_NUMBER_SIZE_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_CONTAINS_BONUS_NUMBER("[ERROR] 당첨 번호에 보너스 번호가 이미 존재합니다."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 로또 번호는 1~45 사이의 숫자만 가능합니다."),

    PURCHASE_PRICE_ONLY_NUMBER("[ERROR] 잘못된 입력입니다. 양의 정수를 입력해주세요."),
    PURCHASE_PRICE_DIVIDE_ERROR("[ERROR] 구입금액은 1000원 단위로만 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
