package lotto.io.error;

public class ErrorMessage {
    public static final String EMPTY_INPUT_PURCHASE_AMOUNT = "[Error] 입력값이 Null이여서는 안됩니다.";
    public static final String EMPTY_INPUT_LOTTO_NUMBER = "[Error] 입력값이 Null이여서는 안됩니다.";
    public static final String INVALID_CHAR_INCLUDED_IN_PURCHASE_INPUT = "[Error] 구매 금액에는 공백을 제외한 숫자만 입력해주세요.";
    public static final String FAILED_PARSING_TO_LONG = "[Error] 숫자로 변환할 수 없는 문자열입니다.";
    public static final String HAS_SMALL_CHANGE = "[Error] 1000원 단위로 입력해주세요.";
    public static final String INVALID_LOTTO_LENGTH_RANGE = "[Error] 중복되지 않은 6개의 숫자를 입력해주세요.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "[Error] 1부터 45 사이의 숫자를 입력해주세요.";
}
