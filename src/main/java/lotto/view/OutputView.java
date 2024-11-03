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

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(formatLottoNumbers(lotto.getNumbers()));
        }
    }

    private String formatLottoNumbers(List<LottoNumber> numbers) {
        return numbers.stream()
                .map(number -> String.valueOf(number.lottoNumber()))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public void printWinningStatistic(LottoStatistic statistic) {
        System.out.println(WINNING_STATISTIC_HEADER);
        Map<WinningRank, Integer> rankCount = statistic.getRankCount();

        WinningRank[] ranks = {
                WinningRank.FIFTH_PLACE,
                WinningRank.FOURTH_PLACE,
                WinningRank.THIRD_PLACE,
                WinningRank.SECOND_PLACE,
                WinningRank.FIRST_PLACE
        };

        for (WinningRank rank : ranks) {
            if (rank == WinningRank.SECOND_PLACE) {
                System.out.printf(WINNING_STATISTIC_SECOND_FORMAT + "%n",
                        rank.getPrize(), rankCount.get(rank));
                continue;
            }
            System.out.printf(WINNING_STATISTIC_FORMAT + "%n",
                    rank.getMatchCount(), rank.getPrize(), rankCount.get(rank));
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_FORMAT + "%n", profitRate);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}