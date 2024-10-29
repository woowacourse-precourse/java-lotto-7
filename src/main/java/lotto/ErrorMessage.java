package lotto;

public class ErrorMessage {
    private ErrorMessage() {
    }

    public static final String INVALID_PURCHASE_AMOUNT_RANGE = "[ERROR] 구입 금액은 1000원이상 100000원 이하로 입력 가능합니다.";
    public static final String INVALID_PURCHASE_AMOUNT_UNIT = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";
    public static final String INVALID_PURCHASE_AMOUNT_FORMAT = "[ERROR] 구입 금액은 공백없이 숫자만 입력 가능합니다.";
}
