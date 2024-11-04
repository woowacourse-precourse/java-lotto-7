package lotto.validate;

public enum ErrorMessages {
    NEGATIVE_PURCHASE_AMOUNT("[ERROR] 구입 금액이 양수이여야 합니다."),
    INVALID_UNIT_PRICE("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    DUPLICATE_NUMBERS("[ERROR] 중복된 숫자가 있습니다."),
    INVALID_BONUS_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    NOT_A_NUMBER("[ERROR] 숫자가 아닌 값이 입력되었습니다."),
    OUT_OF_RANGE("[ERROR] 번호는 1부터 45 사이여야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
