package lotto.view;

import lotto.common.constant.LottoPrizeRank;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printPurchaseLotteryTickets(List<Lotto> lotteryTickets) {
        System.out.printf("\n%d개를 구매했습니다.\n", lotteryTickets.size());
        printLotteryTickets(lotteryTickets);
    }

    private void printLotteryTickets(List<Lotto> lotteryTickets) {
        lotteryTickets.forEach(lotto ->
                System.out.println(formatLottoNumbers(lotto.getNumbers())));
    }


    private String formatLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public void printWinningStatistics(LottoResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        printWinningResults(result);
        printProfitRate(result);
    }

    private void printWinningResults(LottoResult result) {
        LottoPrizeRank.getWinningRanks().forEach(rank ->
                System.out.printf("%s - %d개\n",
                        formatWinningRank(rank),
                        result.getWinningStatistics().getOrDefault(rank, 0)));
    }

    private String formatWinningRank(LottoPrizeRank rank) {
        return String.format("%s (%,d원)",
                rank.getDescription(),
                rank.getPrizeMoney());
    }

    private void printProfitRate(LottoResult result) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n",
                result.calculateProfitRate());
    }
}
