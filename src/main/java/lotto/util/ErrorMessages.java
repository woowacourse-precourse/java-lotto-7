package lotto.util;


public class ErrorMessages {

    public static final String INVALID_AMOUNT_FORMAT = "[ERROR] 구입 금액은 숫자여야 합니다.";
    public static final String INVALID_AMOUNT_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    public static final String EMPTY_LOTTO_TICKET_LIST = "[ERROR] 리스트는 비어있을 수 없습니다.";
    public static final String INVALID_WINNING_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_WINNING_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String INVALID_WINNING_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String INVALID_NUMBER_INPUT = "[ERROR] 입력값은 숫자여야 합니다.";
    public static final String INVALID_BONUS_NUMBER_INPUT = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    public static final String INVALID_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String ERROR_MULTIPLE_BONUS_NUMBERS = "[ERROR] 보너스 번호는 하나만 입력해야 합니다.";

    private ErrorMessages() {
    }
}
