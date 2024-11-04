package lotto.constant;

public class ErrorMessage {
    public static final String INVALID_INPUT_BLANK_ERROR = "[ERROR] 입력은 공백이 아닌 숫자여야 합니다.";
    public static final String INVALID_INPUT_WITH_BLANK_ERROR = "[ERROR] 입력은 공백이 포함되지 않은 입력이어야 합니다.";

    public static final String INVALID_LOTTO_NUMBER_CHARACTER_ERROR = "[ERROR] 로또 번호는 문자가 아닌 숫자여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static final String INVALID_PURCHASE_AMOUNT_CHARACTER_ERROR = "[ERROR] 구입 금액은 문자가 아닌 숫자여야 합니다.";
    public static final String INVALID_PURCHASE_AMOUNT_ERROR = "[ERROR] 구입 금액은 양수인 숫자여야 합니다.";
    public static final String INVALID_PURCHASE_AMOUNT_UNIT_ERROR = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";

    public static final String INVALID_WINNING_NUMBER_SPLIT_ERROR = "[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분한 숫자들이어야 합니다.";

    public static final String INVALID_BONUS_NUMBER_DUPLICATION_ERROR = "[ERROR] 보너스 번호는 당첨 번호에 중복되지 않는 숫자여야 합니다.";

    public static final String INVALID_LOTTO_COUNT_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String INVALID_LOTTO_DUPLICATION_ERROR = "[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다.";
}
