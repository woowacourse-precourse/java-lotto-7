package lotto;

import java.util.regex.Pattern;

public class Constants {
    public static final String LOTTO_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    public static final String LOTTO_AMOUNT_OUTPUT = "개를 구매했습니다.";
    public static final String LOTTO_WINNING_NUMS_INPUT = "\n당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUM_INPUT = "\n보너스 번호를 입력해 주세요.";


    public static final String DELIMITER = ",";

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;

    public static final Pattern winningNumsPattern = Pattern.compile("^(\\d{1,2})(,\\d{1,2})*$");

    public static final String LOTTO_AMOUNT_BLANK_ERROR = "[ERROR] 구입 금액이 공백입니다.";
    public static final String LOTTO_AMOUNT_CONTAINS_STRING_ERROR = "[ERROR] 구입 금액에 문자열이 포함되어 있습니다.";
    public static final String LOTTO_AMOUNT_UNIT_ERROR = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";
    public static final String LOTTO_NUMS_DUPLICATE_ERROR = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";

    public static final String WINNING_NUMS_INPUT_BLANK_ERROR = "[ERROR] 당첨 번호이 공백입니다.";
    public static final String WINNING_NUMS_PARSING_ERROR = "[ERROR] 정해진 숫자가 아닌 문자열이 있습니다.";
    public static final String WINNING_NUMS_RANGE_ERROR = "[ERROR] 당첨 번호의 범위에서 벗어납니다.";
    public static final String WINNING_NUMS_DUPLICATE_ERROR = "[ERROR] 당첨 번호에 중복된 숫자가 있습니다.";
    public static final String WINNING_NUMS_SIZE_ERROR = "[ERROR] 당첨 번호의 개수에 오류가 있습니다.";

    public static final String BONUS_NUM_BLANK_ERROR = "[ERROR] 보너스 번호에는 공백이 입력될 수 없습니다.";
    public static final String BONUS_NUM_PARSE_ERROR = "[ERROR] 보너스 번호에 문자열이 있습니다.";
    public static final String BONUS_NUM_DUPLICATE_ERROR = "[ERROR] 보너스 번호와 당첨번호가 중복됩니다.";
    public static final String BONUS_NUM_RANGE_ERROR = "[ERROR] 보너스 번호의 범위가 잘못되었습니다.";
}
