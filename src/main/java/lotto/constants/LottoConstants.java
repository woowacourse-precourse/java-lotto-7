package lotto.constants;

import java.util.Map;

public class LottoConstants {
    // LottoGenerator 클래스
    public static final int NUMBER_OF_NUMBERS = 6;
    public static final int RANDOM_MIN = 1;
    public static final int RANDOM_MAX = 45;

    // LottoService 클래스
    public static final int PERCENT = 100;
    public static final int PLACE_TO_ROUND_TO = 1;
    public static final int INITIAL_WINNING_COUNT = 0;


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
