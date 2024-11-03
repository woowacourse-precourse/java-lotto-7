package lotto.constants;

import java.util.Map;

public class LottoConstants {
    // LottoGenerator 클래스
    public static final int NUMBER_OF_NUMBERS = 6;
    public static final int RANDOM_MIN = 1;
    public static final int RANDOM_MAX = 45;

    // LottoService 클래스
    public static final long LOTTO_PRICE = 1000L;
    public static final int PERCENT = 100;
    public static final int PLACE_TO_ROUND_TO = 1;
    public static final int NUMBER_OF_RANKS = 5;
    public static final int INITIAL_WINNING_COUNT = 0;
    public static final int FIRST_RANK = 1;
    public static final int SECOND_RANK = 2;
    public static final int THIRD_RANK = 3;
    public static final int FOURTH_RANK = 4;
    public static final int FIFTH_RANK = 5;
    public static final int FIRST_RANK_MATCH_COUNT = 6;
    public static final int SECOND_RANK_MATCH_COUNT = 5;
    public static final int THIRD_RANK_MATCH_COUNT = 5;
    public static final int FOURTH_RANK_MATCH_COUNT = 4;
    public static final int FIFTH_RANK_MATCH_COUNT = 3;
    public static final int FIRST_RANK_PRIZE_AMOUNT = 2000000000;
    public static final int SECOND_RANK_PRIZE_AMOUNT = 30000000;
    public static final int THIRD_RANK_PRIZE_AMOUNT = 1500000;
    public static final int FOURTH_RANK_PRIZE_AMOUNT = 50000;
    public static final int FIFTH_RANK_PRIZE_AMOUNT = 5000;

    /* (n, m) n개 일치 시 m등 */
    public static final Map<Integer, Integer> RANK_BY_MATCH_COUNT = Map.of(
            FIFTH_RANK_MATCH_COUNT, FIFTH_RANK,
            FOURTH_RANK_MATCH_COUNT, FOURTH_RANK,
            THIRD_RANK_MATCH_COUNT, THIRD_RANK,
            FIRST_RANK_MATCH_COUNT, FIRST_RANK
    );
    /* (a, b) a등 b개 일치 */
    public static final Map<Integer, Integer> MATCH_COUNT_BY_RANK = Map.of(
            FIFTH_RANK, FIFTH_RANK_MATCH_COUNT,
            FOURTH_RANK, FOURTH_RANK_MATCH_COUNT,
            THIRD_RANK, THIRD_RANK_MATCH_COUNT,
            SECOND_RANK, SECOND_RANK_MATCH_COUNT,
            FIRST_RANK, FIRST_RANK_MATCH_COUNT
    );
    /* (m, k) m등 상금 k원 */
    public static final Map<Integer, Integer> PRIZE_AMOUNT_BY_RANK = Map.of(
            FIFTH_RANK, FIFTH_RANK_PRIZE_AMOUNT,
            FOURTH_RANK, FOURTH_RANK_PRIZE_AMOUNT,
            THIRD_RANK, THIRD_RANK_PRIZE_AMOUNT,
            SECOND_RANK, SECOND_RANK_PRIZE_AMOUNT,
            FIRST_RANK, FIRST_RANK_PRIZE_AMOUNT
    );

    // NumbersValidator 클래스
    public static final String ERROR_MESSAGE_BEGINNING = "[ERROR]";
    public static final String INPUT_DELIMITER = ",";
    public static final String NUMBERS = "로또 번호";
    public static final String WINNING = "당첨";
    public static final String BONUS = "보너스";
    public static final Map<String, Integer> LENGTH_BY_NUMBER_TYPE = Map.of(
            WINNING, 6,
            BONUS, 1
    );

    // PurchaseAmountValidator 클래스
    public static final String PURCHASE_AMOUNT = "구입 금액";
    public static final int PURCHASE_AMOUNT_THRESHOLD = 0;
    public static final int PURCHASE_AMOUNT_UNIT = 1000;

    // OutputView 클래스
    public static final String LINE_SPACE = "\n";
    public static final String PURCHASE_AMOUNT_TEXT = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBERS_TEXT = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_TEXT = "보너스 번호를 입력해 주세요.";
    public static final String LOTTO_COUNT_TEXT = "%d개를 구매했습니다.";
    public static final String TICKET_START_TEXT = "[";
    public static final String TICKET_END_TEXT = "]";
    public static final String WINNING_RESULT_TEXT = "당첨 통계";
    public static final String DIVIDING_LINE = "---";
    public static final String JOIN_DELIMITER = ", ";
    public static final String DESCRIPTION = "%d개 일치 (%s원) - %d개";
    public static final String SECOND_RANK_DESCRIPTION = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    public static final String EARNINGS_RATE_TEXT = "총 수익률은 %s%%입니다.";
}
