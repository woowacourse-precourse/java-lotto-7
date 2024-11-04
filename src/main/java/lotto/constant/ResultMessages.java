package lotto.constant;

public class ResultMessages {
    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static final String WINNING_STATISTICS_HEADER = "\n당첨 통계";
    public static final String WINNING_STATISTICS_DIVIDER = "---";
    public static final String BONUS_STATISTICS_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    public static final String REGULAR_STATISTICS_FORMAT = "%d개 일치 (%,d원) - %d개%n";
    public static final String RATE_EARNING_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private ResultMessages() {
        // 인스턴스 생성 방지
    }
}
