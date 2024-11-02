package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class OutputView {
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat("#,###");

    public void printIssuedLottos(List<Lotto> issuedLottos) {
        System.out.printf("\n%d개를 구매했습니다.%n", issuedLottos.size());
        for (Lotto lotto : issuedLottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printResults(List<LottoResult> results) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<Rank, Long> rankCounts = results.stream()
                .collect(Collectors.groupingBy(LottoResult::getRank, Collectors.counting()));

        for (int i = Rank.values().length - 1; i >= 0; i--) { //역순으로 5등 결과부터 출력
            Rank rank = Rank.values()[i];
            if (rank != Rank.NONE) {
                String message = getRankMessage(rank, rankCounts.getOrDefault(rank, 0L));
                System.out.println(message);
            }
        }
    }

    private String getRankMessage(Rank rank, long count) {
        String formattedWinningAmount = MONEY_FORMAT.format(rank.getWinnings());
        if (rank.equals(Rank.SECOND)) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", rank.getMatchCount(), formattedWinningAmount, count);
        }
        return String.format("%d개 일치 (%s원) - %d개", rank.getMatchCount(), formattedWinningAmount, count);
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", Math.round(profitRate * 100) / 100.0);
    }
}
