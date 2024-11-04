package lotto.view;

import static lotto.common.config.InstructionMessages.WINNING_STATISTICS;

import java.util.List;
import lotto.common.config.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.WinningStatistics;

public class Output {
    private static final String DIVIDER = "\n---";
    private static final String NUMBER_OF_PURCHASE = "\n%d개를 구매했습니다.\n";
    private static final String TOTAL_PROFIT = "총 수익률은 %.1f%%입니다.\n";
    private static final String STATISTICS_BONUS = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String STATISTICS = "%d개 일치 (%,d원) - %d개\n";

    public void printLottoNumbers(List<Lotto> lottoNumbers) {
        System.out.printf(NUMBER_OF_PURCHASE, lottoNumbers.size());
        for (Lotto lottoNumber : lottoNumbers) {
            printMessage(String.valueOf(lottoNumber));
        }
    }

    public void printWinningStatistics(WinningStatistics statistics, double profitRate) {
        printMessage(WINNING_STATISTICS.getMessage() + DIVIDER);
        for (LottoRank rank : LottoRank.values()) {
            printRankStatistics(rank, statistics.getRankCount(rank));
        }
        printFormat(TOTAL_PROFIT, profitRate);
    }

    private void printRankStatistics(LottoRank rank, int rankCount) {
        if (rank == LottoRank.MATCH_5_BONUS) {
            printFormat(STATISTICS_BONUS, rank.getMatchCount(), rank.getPrize(), rankCount);
            return;
        }
        printFormat(STATISTICS, rank.getMatchCount(), rank.getPrize(), rankCount);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printFormat(String format, Object... args) {
        System.out.printf(format, args);
    }
}
