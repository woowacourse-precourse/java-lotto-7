package lotto.message;

public class ErrorMessage {

    public final static String ERROR_INPUT_PURCHASE_AMOUNT = "[ERROR] 구입 금액을 입력해 주세요.";
    public static final String ERROR_NON_NUMERIC_INPUT = "[ERROR] 숫자를 입력해주세요.";
    public static final String ERROR_NEGATIVE_PRICE = "[ERROR] 음수는 입력할 수 없습니다.";
    public static final String ERROR_INVALID_UNIT = "[ERROR] 1000원 단위로 입력해주세요.";

    public static final String ERROR_NOT_SEPARATED = "[ERROR] 입력값에 쉼표(,) 구분자가 포함되어 있지 않습니다.";
    public static final String ERROR_EMPTY_WINNING_NUMBERS = "[ERROR] 당첨 번호를 입력하셔야 합니다.";
    public static final String ERROR_WINNING_NUMBERS_SIZE_LESS = "[ERROR] 당첨 번호는 6개를 입력해야 합니다.";
    public static final String ERROR_WINNING_NUMBERS_SIZE_MORE = "[ERROR] 당첨 번호는 6개를 초과할 수 없습니다.";
    public static final String ERROR_WINNING_NUMBERS_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_DUPLICATE_WINNING_NUMBERS = "[ERROR] 당첨 번호에 중복된 번호가 있습니다.";

    public static final String ERROR_EMPTY_BONUS_NUMBER = "[ERROR] 보너스 번호를 입력해주세요.";
    public static final String ERROR_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1부터 45까지의 숫자만 가능합니다.";
    public static final String ERROR_DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

}
