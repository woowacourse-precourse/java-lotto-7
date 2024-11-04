package view.message;

import java.text.DecimalFormat;

public class ViewMessage {

    public static final DecimalFormat THOUSANDS_COMMA_FORMAT = new DecimalFormat("#,###");
    public static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    public static final String PURCHASE_QUANTITY_MESSAGE = "%n%s개를 구매했습니다.%n";
    public static final String LOTTO_RESULT_MESSAGE = "\n당첨 통계\n---";
    public static final String MATCH_COUNT_MESSAGE = "%d개 일치";
    public static final String MATCHED_BONUS_NUMBER_MESSAGE = ", 보너스 볼 일치";
    public static final String PRIZE_AND_RANK_COUNT_MESSAGE = " (%s원) - %d개%n";
    public static final String RETURN_ON_INVESTMENT_MESSAGE = "총 수익률은 %,.1f%%입니다.%n";
}
