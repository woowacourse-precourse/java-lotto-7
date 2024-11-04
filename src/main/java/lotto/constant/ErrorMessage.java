package lotto.constant;

public class ErrorMessage {

    public static final String PURCHASE_TYPE_EXCEPTION = "[ERROR] 구입 금액에는 숫자만 들어갈 수 있습니다.";
    public static final String PURCHASE_RANGE_EXCEPTION = "[ERROR] 구입 금액은 0이나 음수가 될 수 없습니다.";
    public static final String PURCHASE_UNIT_EXCEPTION = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    public static final String LOTTO_DUPLICATE_EXCEPTION = "[ERROR] 로또 번호에 중복된 값이 있습니다.";
    public static final String LOTTO_RANGE_EXCEPTION = "[ERROR] 로또 번호는 1~45의 범위만 가능합니다.";
    public static final String LOTTO_TYPE_EXCEPTION = "[ERROR] 로또 번호에 숫자만 입력해주세요.";
}

