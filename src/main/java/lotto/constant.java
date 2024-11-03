package lotto;

public class constant {
    // 숫자 상수
    public static final int LOTTOPRICE = 1000;
    public static final int PERCENT = 100;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    public static final int NUMBER_SIZE = 6;

    // 문자열 상수

    public static final String PAYMENT_MASSAGE = "구입 금액을 입력해 주세요.";
    public static final String TICKETS_PRINT = "개를 구매했습니다.";
    public static final String SET_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요";
    public static final String SET_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String RESULT_STATISTICS ="당첨 통계";
    public static final String LINE = "---";
    public static final String ERROR_PREFIX = "[ERROR]";
    public static final String PAYMENT_ERROR = ERROR_PREFIX + " 1000원 단위로 입력해 주세요.";
    public static final String EMPTY_ERROR = ERROR_PREFIX + " 입력값이 없습니다.";
    public static final String REST_ERROR = ERROR_PREFIX + " 잘못된 쉼표 사용입니다.";
    public static final String INTEGER_ERROR = ERROR_PREFIX + " 정수를 입력해 주세요.";
    public static final String OUTOFRANGE_ERROR = ERROR_PREFIX + " 1~45사이의 정수를 입력해주세요.";
    public static final String DUPLICATING_ERROR = ERROR_PREFIX + " 숫자가 중복되었습니다.";
    public static final String NUMBERSIZE_ERROR = ERROR_PREFIX + " 6개의 숫자를 입력해주세요.";
}
