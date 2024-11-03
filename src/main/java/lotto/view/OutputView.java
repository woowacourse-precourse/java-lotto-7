package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String OUTPUT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTIC_HEADER = "당첨 통계\n---";
    private static final String WINNING_STATISTIC_FORMAT = "%d개 일치 (%,d원) - %d개";
    private static final String WINNING_STATISTIC_SECOND_FORMAT = "5개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printBuyLotto(Money money) {
        System.out.printf((OUTPUT_MESSAGE) + "%n", money.getTicket());
    }
}