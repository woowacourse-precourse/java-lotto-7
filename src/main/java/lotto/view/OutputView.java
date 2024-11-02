package lotto.view;

import lotto.domain.Prize;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private final String PRINT_BOUGHT_AMOUNT = "\n%d개를 구매했습니다.\n";
    private final String PRINT_LOTTO_NUMBERS_DELIMITER = ", ";
    private final String PRINT_LOTTO_NUMBERS_FORMAT = "[%s]\n";
    private final String PRINT_WINNING_STATISTIC = "당첨 통계\n---\n";
    private final String PRINT_MATCH_COUNTS_FORMAT = "%d개 일치%s (%,d원) - %d개\n";
    private final String PRINT_EARNING_RATIO_FORMAT = "총 수익률은 %s%%입니다.";

    public void printBoughtLottoNumbers(List<List<Integer>> lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PRINT_BOUGHT_AMOUNT, lottos.size()));
        for (List<Integer> lotto : lottos) {
            String joined = lotto.stream().map(String::valueOf).collect(Collectors.joining(PRINT_LOTTO_NUMBERS_DELIMITER));
            sb.append(String.format(PRINT_LOTTO_NUMBERS_FORMAT, joined));
        }
        System.out.print(sb);
    }

    public void printWinningStatistic(Map<Prize, Integer> matchCounts, String earningRatio) {
        StringBuilder sb = new StringBuilder();
        sb.append(PRINT_WINNING_STATISTIC).append(printMatchCounts(matchCounts)).append(printEarningRatio(earningRatio));
        System.out.print(sb);
    }

    private StringBuilder printMatchCounts(Map<Prize, Integer> matchCounts) {
        StringBuilder sb = new StringBuilder();
        for (Prize prize : Prize.values()) {
            if (prize == Prize.LOSE) {
                continue;
            } else if (prize.isBonusNumMatch()) {
                sb.append(String.format(PRINT_MATCH_COUNTS_FORMAT, prize.getStandard(), ", 보너스 볼 일치", prize.getAmount(), matchCounts.get(prize)));
                continue;
            }
            sb.append(String.format(PRINT_MATCH_COUNTS_FORMAT, prize.getStandard(), "", prize.getAmount(), matchCounts.get(prize)));
        }
        return sb;
    }

    private StringBuilder printEarningRatio(String earningRatio) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PRINT_EARNING_RATIO_FORMAT, earningRatio));
        return sb;
    }
}
