package lotto.util;

public class Constants { // 하드 코딩되어있는 것들

    public static final String SEPARATOR = ",";
    public static final int PURCHASE_FORM = 1000;

    public static final int MAX_NUM = 100000;

    public static final int BONUS_MATCH_COUNT = 5;
    public static final String VALID_INPUT_PATTERN = "^[0-9\\s]+("+SEPARATOR+"[0-9\\s]+)*$";
    public static final String LOTTO_COST_INPUT = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_LOTTO_OUTPUT = "개를 구매했습니다.";

    public static final String WINNING_LOTTO_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";

    public static final String RESULT_LOTTO_OUTPUT = "당첨 통계\n" + "---";

}
