package lotto;

public class ErrorMessage {
    public static final String INVALID_PURCHASE_AMOUNT_RANGE = "[ERROR] 구입 금액은 1000원이상 100000원 이하로 입력 가능합니다.";
    public static final String INVALID_PURCHASE_AMOUNT_UNIT = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";
    public static final String INVALID_PURCHASE_AMOUNT_FORMAT = "[ERROR] 구입 금액은 공백없이 숫자만 입력 가능합니다.";
    public static final String INVALID_WINNING_NUMBER_FORMAT = "[ERROR] 당첨 번호는 공백없이 숫자만 입력 가능합니다.";
    public static final String INVALID_LOTTO_NUMBER_COUNT = "[ERROR] 당첨 번호는 6개여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 당첨 번호에 중복된 숫자가 있습니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "[ERROR] 당첨 번호는 1이상 45이하로 입력 가능합니다.";
    public static final String INVALID_BONUS_NUMBER_FORMAT = "[ERROR] 보너스 번호는 1이상 45이하로 입력 가능합니다.";
    public static final String INVALID_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1이상 45이하로 입력 가능합니다.";
    public static final String DUPLICATE_BONUS_NUMBER = "[ERROR] 당첨 번호와 중복되는 보너스 번호입니다.";

    private ErrorMessage() {
    }
}
