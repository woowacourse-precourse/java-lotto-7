package lotto.view;

import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_NUMBERS_MESSAGE = "%s";
    private static final String HEADER = "당첨 통계\n---";
    private static final String TOTAL_PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.%n";
    private static final String RANK_COUNT_MESSAGE = "%s - %d개%n";

    public void printLottoTickets(LottoTicket lottoTicket) {
        int count = lottoTicket.getCount();
        System.out.println();
        System.out.printf(LOTTO_COUNT_MESSAGE, count);
        System.out.println();

        lottoTicket.getLottoTicket().forEach(lotto -> {
            System.out.printf(LOTTO_NUMBERS_MESSAGE, lotto.getNumbers().toString());
            System.out.println();
        });
        System.out.println();
    }

    public void printWinningStatistics(Map<LottoRank, Integer> rankCountMap) {
        System.out.println();
        System.out.println(HEADER);
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.LOSE) {
                int count = rankCountMap.get(rank);
                System.out.printf(RANK_COUNT_MESSAGE, rank.getDescription(), count);
            }
        }
    }

    public void printTotalProfitRate(double profitRate) {
        System.out.printf(TOTAL_PROFIT_RATE_MESSAGE, profitRate);
    }
}