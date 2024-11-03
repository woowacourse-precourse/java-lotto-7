package lotto.util;

public class Constants { // 하드 코딩되어있는 것들

    public static final String SEPARATOR = ",";
    public static final int PURCHASE_FORM = 1000;

    public static final int MAX_NUM = 100000;

    public static final int BONUS_MATCH_COUNT = 5;
    public static final String VALID_INPUT_PATTERN = "^[0-9]+(\\s*" + SEPARATOR + "\\s*[0-9]+)*$";
    // 숫자 그룹 내에는 공백을 허용하지 않으며, 숫자 그룹 간의 구분 기호 양쪽에 선택적으로 공백을 허용한다
    public static final String LOTTO_COST_INPUT = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_LOTTO_OUTPUT = "개를 구매했습니다.";

    public static final String WINNING_LOTTO_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";

    public static final String RESULT_LOTTO_OUTPUT = "당첨 통계\n" + "---";

}
