package lotto.view;

import java.util.List;
import lotto.dto.LottoTicketsDto;
import lotto.dto.WinningStatisticsDto;
import lotto.dto.WinningStatisticsDto.WinningCountDto;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String STATISTICS_HEADER = "\n당첨 통계\n---\n";
    private static final String MATCH_FORMAT = "%d개 일치%s (%,d원) - %d개\n";
    private static final String RETURN_RATE_FORMAT = "총 수익률은 %,.1f%%입니다.\n";
    private static final String BONUS_MATCH = ", 보너스 볼 일치";
    private static final String EMPTY_STRING = "";
    private static final String NEW_LINE = "\n";

    public void printLottoTickets(LottoTicketsDto lottoTicketsDto) {
        StringBuilder result = new StringBuilder();
        result.append(String.format(PURCHASE_MESSAGE, lottoTicketsDto.purchaseCount()));

        for (List<Integer> numbers : lottoTicketsDto.lottoNumbers()) {
            result.append(numbers).append(NEW_LINE);
        }

        System.out.println(result);
    }

    public void printWinningStatistics(WinningStatisticsDto winningStatisticsDto) {
        StringBuilder result = new StringBuilder(STATISTICS_HEADER);

        for (WinningCountDto winningCount : winningStatisticsDto.WinningCountDtos()) {
            result.append(formatWinningCount(winningCount));
        }

        result.append(String.format(RETURN_RATE_FORMAT, winningStatisticsDto.returnRate() * 100));
        System.out.println(result);
    }

    private String formatWinningCount(WinningCountDto winningCount) {
        return String.format(
                MATCH_FORMAT,
                winningCount.matchCount(),
                getBonusMatchMessage(winningCount.hasBonusNumber()),
                winningCount.prize(),
                winningCount.count()
        );
    }

    private static String getBonusMatchMessage(boolean hasBonusNumber) {
        if (hasBonusNumber) {
            return BONUS_MATCH;
        }
        return EMPTY_STRING;
    }
}
