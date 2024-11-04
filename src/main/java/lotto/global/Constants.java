package lotto.global;

public final class Constants {

    private Constants() {
    }

    // 출력 템플릿 상수
    public static final String PURCHASE_INFO_TEMPLATE = "%n%d개를 구매했습니다.%n";
    public static final String WINNING_STATISTICS_HEADER = "%n당첨 통계%n---%n";
    public static final String PROFIT_RATE_TEMPLATE = "총 수익률은 %.1f%%입니다.%n";
    public static final String RESULT_FORMAT = "%s (%s원) - %d개%n";
    public static final String MATCH_COUNT_SUFFIX = "개 일치";
    public static final String BONUS_BALL_MATCH = ", 보너스 볼 일치";
    public static final String LOTTO_NUMBERS_SEPARATOR = ", ";
    public static final String LOTTO_NUMBERS_PREFIX = "[";
    public static final String LOTTO_NUMBERS_SUFFIX = "]";

    // 금액 관련 상수
    public static final int LOTTO_PRICE = 1000;
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBERS_COUNT = 6;
    public static final long MAX_PURCHASABLE_LOTTOS = 1_000_000_000;
    public static final int PROFIT_RATE_ROUNDING_SCALE = 2;

    // 메시지 관련 상수
    public static final String LOTTO_PURCHASE_MONEY_PROMPT = "구입 금액을 입력해 주세요.%n";
    public static final String WINNING_NUMBER_PROMPT = "%n당첨 번호를 입력해 주세요.%n";
    public static final String BONUS_NUMBER_PROMPT = "%n보너스 번호를 입력해 주세요.%n";
}