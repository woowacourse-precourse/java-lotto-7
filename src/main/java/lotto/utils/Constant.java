package lotto.utils;

public class Constant {
    public final static String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public final static String LOTTO_PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    public final static String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public final static String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    public final static String LOTTO_RESULT_MESSAGE = "당첨 통계";
    public final static String HORIZONTAL_DIVIDER_MESSAGE = "---";
    public final static String LOTTO_WINNING_STATUS_MESSAGE = "%s - %d개";
    public final static String LOTTO_PRIZE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    public static final String INTEGER_REGEX = "[0-9]+";
    public static final String WINNING_NUMBER_INPUT_DELIMITER = ",";

    public static final int MIN_PURCHASE_AMOUNT = 1000;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MAX_LOTTO_NUMBER_COUNT = 6;
    public static final int CHECK_BONUS_NUMBER = 5;
    public static final int DEFAULT_MATCH_COUNT_VALUE = 0;

    private Constant() {
    }
}
