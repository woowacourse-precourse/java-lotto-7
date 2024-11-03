package lotto.util;

public class ErrorMessage {
    private ErrorMessage() {}

    public static final String INPUT_NUMBER_FORMAT = "[ERROR] 숫자만 입력 가능합니다.";
    public static final String PURCHASE_MONEY_DIVIDE = "[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.";
    public static final String PURCHASE_MONEY_MINIMUM = "[ERROR] 로또 구입 금액은 0원 이상이어야 합니다.";
    public static final String PURCHASE_MONEY_MAXIMUM = "[ERROR] 100,000원까지만 구입 가능합니다.";
    public static final String LOTTO_NUMBER_FORMAT = "[ERROR] 올바른 로또 번호 입력 형식이 아닙니다.";
    public static final String LOTTO_NUMBER_DUPLICATE = "[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.";
    public static final String LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1~45 사이의 값이어야 합니다.";
    public static final String LOTTO_NUMBER_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
}
