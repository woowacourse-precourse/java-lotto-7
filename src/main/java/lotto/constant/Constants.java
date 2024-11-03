package lotto.constant;

public final class Constants {

    //에러 메세지
    public static final String ERROR_NO_BLANK_OR_NULL = "[ERROR] 빈칸 없이 입력해주세요.";
    public static final String ERROR_COMMA_WITH_NUMBERS = "[ERROR] 쉼표를 구분자로 한자리의 숫자씩만 입력해주세요.";
    public static final String ERROR_NUMBER_MUST_BE_SIX = "[ERROR] 숫자는 총 6개여야 합니다.";
    public static final String ERROR_NO_DUPLICATE = "[ERROR] 숫자는 중복되지 않게 입력해주세요";
    public static final String ERROR_NUMBER_BETWEEN_ONE_TO_FORTY_FIVE = "[ERROR] 숫자는 1에서 45 사이의 숫자를 입력해 주세요.";
    public static final String ERROR_FORMAT_IS_NUMBER = "[ERROR] 숫자를 입력해 주세요";
    public static final String ERROR_DUPLICATED_BONUS_NUMBER = "[ERROR] 당첨 번호와 다른 번호를 입력해 주세요";
    public static final String ERROR_MORE_THAN_THOUSAND = "[ERROR] 천 이상의 숫자만 입력해 주세요.";
    public static final String ERROR_THOUSAND_UNIT = "[ERROR] 천원단위로 입력해 주세요";

    //기타 상수
    public static final String DELIMITER_COMMA = ",";
    public static final int THOUSAND_UNIT = 1000;
    public static final int MAX_LOTTO_COUNT = 6;
    public static final int MIN_LOTTO_RANGE = 1;
    public static final int MAX_LOTTO_RANGE = 45;
    public static final int ZERO = 0;
    public static final int INCREASE_VALUE_ONE = 1;
    public static final int GET_PERCENTAGE_BY_HUNDRED = 100;
    public static final String NEXT_LINE = "\n";
    public static final String DECIMAL_FORMAT_ONE_PLACE = "%.1f";

    //정규표현식

    public static final String MONEY_REGEX = "^\\d{4,}$";
    public static final String LOTTO_REGEX = "^[0-9,]+$";
    public static final String NUMBER_REGEX = "\\d+";

    //출력 메세지
    public static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String PROMPT_WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String PROMPT_BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String PROMPT_PURCHASED_LOTTO_COUNT = "개를 구매했습니다.";
    public static final String PRIZE_STATISTICS_HEADER = "당첨 통계";
    public static final String PRIZE_STATISTICS_DIVIDER = "---";
    public static final String SECOND_PRIZE_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    public static final String PRIZE_MESSAGE = "%d개 일치 (%s원) - %d개";
    public static final String WINNING_RATE_MESSAGE = "총 수익률은 %s%%입니다.";


    private Constants() {
    }
}