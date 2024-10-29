package lotto.lottoView;

import java.util.List;

public class OutputView {
    private static final String HOW_MANY_BUY = "개를 구매했습니다.";
    private static final String STATISTIC_START = "당첨 통계\n---";
    private static final String VALUE_MATCH_START = "%d개 일치";
    private static final String VALUE_MATCH_END = " (%d원) - %d개";
    private static final String BONUS_MATCH = ", 보너스 볼 일치";
    private static final String PROFIT_MESSAGE = "총 수익률은 %f %입니다.";


    public void howManyBuy() {
        System.out.println(HOW_MANY_BUY);
    }

    public void statisticStart() {
        System.out.println(STATISTIC_START);
    }
//
//    public void statisticEnd() {
//        if (
//        System.out.printf(VALUE_MATCH_START+VALUE_MATCH_END,
//    }
}
