package lotto.io.error;

public class ErrorMessage {

    private ErrorMessage() {
    }

    public static final String EMPTY_INPUT_PURCHASE_AMOUNT = "[ERROR] 구매 금액이 Null이여서는 안됩니다.";
    public static final String EMPTY_INPUT_LOTTO_NUMBER = "[ERROR] 당첨 번호가 Null이여서는 안됩니다.";
    public static final String EMPTY_INPUT_BONUS_NUMBER = "[ERROR] 보너스 번호가 Null이여서는 안됩니다.";
    public static final String INVALID_CHAR_INCLUDED_IN_PURCHASE_INPUT = "[ERROR] 구매 금액에는 공백을 제외한 숫자만 입력해주세요.";
    public static final String FAILED_PARSING_TO_LONG = "[ERROR] 숫자로 변환할 수 없는 문자열입니다.";
    public static final String HAS_SMALL_CHANGE = "[ERROR] 1000원 단위로 입력해주세요.";
    public static final String INVALID_LOTTO_LENGTH_RANGE = "[ERROR] 중복되지 않은 6개의 숫자를 입력해주세요.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "[ERROR] 1부터 45 사이의 숫자를 입력해주세요.";
    public static final String ALREADY_PICKED_NUMBER = "[ERROR] 1부터 45 사이의 숫자를 입력해주세요.";
}
