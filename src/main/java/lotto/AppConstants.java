package lotto;

public class AppConstants {
    public static final String INSERT_MONEY = "구입금액을 입력해 주세요.";
    public static final String INSERT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INSERT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String PRINT_SOLD_LOTTO_COUNT = "%d개를 구매했습니다.";
    public static final String PRIZE_MATCH_RESULT_TEMPLATE = "%d개 일치 (%s원) - %d개";
    public static final String SECOND_PRIZE_MATCH_RESULT_TEMPLATE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    public static final String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String SEPARATION_LINE = "---";
    public static final String MONEY_NOT_DIVIDED_BY_1000 = "[ERROR] 로또 구입 금액은 1,000원 단위로 입력 가능합니다.";
    public static final String INPUT_NOT_INTEGER = "[ERROR] 로또 구입 금액은 정수를 입력하셔야 합니다.";
    public static final String MONEY_LESS_THAN_1000 = "[ERROR] 로또 구입 금액은 1,000원 이상이어야 합니다.";
    public static final String INVALID_WINNING_NUMBERS_INPUT = "[ERROR] 올바르지 않은 당첨 번호 입력입니다.";
    public static final String INVALID_BONUS_NUMBERS_INPUT = "[ERROR] 올바르지 않은 보너스 번호 입력입니다.";
    public static final String INVALID_LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_DUPLICATED = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final int MATCH_COUNT_FOR_FIFTH_PRIZE = 3;
    public static final int MATCH_COUNT_FOR_FOURTH_PRIZE = 4;
    public static final int MATCH_COUNT_FOR_THIRD_PRIZE = 5;
    public static final int MATCH_COUNT_FOR_FIRST_PRIZE = 6;
    public static final int MATCH_COUNT_FOR_SECOND_PRIZE = 7;

    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
}
