package lotto.constants.view;

public final class OutputViewMessage {

    public static final String RESULT_HEADER = "당첨 통계\n---\n";
    public static final String EXCEPT_SECOND_PLACE_RESULT_MESSAGE = "%s개 일치 (%s원) - %d개\n";
    public static final String SECOND_PLACE_RESULT_MESSAGE = "%s개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    public static final String REVENUE_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    public static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";

    private OutputViewMessage() {
    }
}
