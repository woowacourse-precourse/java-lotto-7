package lotto.common;

public class ErrorMessage {
    public static final String INVALID_PURCHASE_AMOUNT = "[ERROR] 로또 구입금액은 1,000원 단위여야 합니다.";
    public static final String INVALID_WINNING_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호는 1개여야 합니다.";
    public static final String NUMBER_OUT_OF_RANGE = "[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String NUMBER_DUPLICATE ="[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
    public static final String INVALID_INPUT = "[ERROR] 유효하지 않은 입력입니다.";
}
