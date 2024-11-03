package lotto.constant;

public class GameMessage {
    // Input Messages
    public static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String PURCHASED_LOTTO_COUNT = "%d개를 구매했습니다.";
    public static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    // Result Messages
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String STATISTICS_DIVIDER = "---";
    public static final String MATCH_RESULT_FORMAT = "%d개 일치 (%,d원) - %d개";
    public static final String MATCH_BONUS_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    public static final String TOTAL_RETURN_RATE = "총 수익률은 %s%%입니다.";
}
