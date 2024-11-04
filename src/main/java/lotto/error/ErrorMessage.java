package lotto.error;

public class ErrorMessage {

    private ErrorMessage() {
    }

    public static final String SHOULD_NOT_BE_NULL = "[Error] Null이여서는 안됩니다.";
    public static final String AMOUNT_SHOULD_NOT_BE_MINUS = "[Error] 금액은 음수가 될 수 없습니다.";
    public static final String INVALID_UNIT_AMOUNT = "[Error] 1000원 단위로 입력해주세요.";
    public static final String DUPLICATED_LOTTO_NUMBER = "[Error] 중복된 로또 번호가 있습니다.";
}
