package lotto.constant;

public class ErrorMessage {

    public static final String ERROR_TAG = "[ERROR] ";
    public static final String BUDGET_NOT_NATURAL_NUMBER = "구입 금액이 자연수가 아닙니다.";
    public static final String BUDGET_NOT_DIVIDED_ONE_THOUSAND = "구입 금액이 1000원으로 나누어 떨어지지 않습니다.";

    public static final String NUMBER_COUNT_NOT_VALID = "로또 번호 개수가 일치하지 않습니다.";
    public static final String NUMBER_OUT_OF_RANGE = "로또 번호의 숫자 범위를 벗어납니다.";
    public static final String NUMBER_DUPLICATED = "번호에 중복이 존재합니다.";

    public static final String WINNING_NUMBERS_NOT_NUMERIC = "당첨 번호가 숫자의 형태가 아닙니다.";

    public static final String BONUS_NUMBER_NOT_NATURAL_NUMBER = "보너스 번호가 자연수가 아닙니다.";
    public static final String BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBERS = "보너스 번호가 당첨 번호와 중복됩니다.";

    private ErrorMessage() {
    }
}
