package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class Output {
    private final String SYSTEM_PURCHASE_OUTPUT_MESSAGE = "개를 구매했습니다.";
    private static final String STATISTICS_HEADER = "당첨 통계";
    private static final String LINE_SEPARATOR = "---";
    private static final String MATCH_3_FORMAT = "3개 일치 (5,000원) - %d개";
    private static final String MATCH_4_FORMAT = "4개 일치 (50,000원) - %d개";
    private static final String MATCH_5_FORMAT = "5개 일치 (1,500,000원) - %d개";
    private static final String MATCH_5_BONUS_FORMAT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String MATCH_6_FORMAT = "6개 일치 (2,000,000,000원) - %d개";
    private static final String PROFIT_RATE = "총 수익률은 %.2f%%입니다.";
    public void printPurchaseCount(int count) {
        System.out.println(count + SYSTEM_PURCHASE_OUTPUT_MESSAGE);
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket.toString());
        }
    }
    public void printResult(int count3, int count4, int count5, int count5Bonus, int count6, double profitRate) {
        System.out.println(STATISTICS_HEADER);
        System.out.println(LINE_SEPARATOR);
        System.out.printf(MATCH_3_FORMAT + "%n", count3);
        System.out.printf(MATCH_4_FORMAT + "%n", count4);
        System.out.printf(MATCH_5_FORMAT + "%n", count5);
        System.out.printf(MATCH_5_BONUS_FORMAT + "%n", count5Bonus);
        System.out.printf(MATCH_6_FORMAT + "%n", count6);
        System.out.printf(PROFIT_RATE + "%n", profitRate);
    }
}
