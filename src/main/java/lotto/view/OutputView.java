package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.RankResult;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printResultBuyCount(long purchaseCount) {
        System.out.printf("\n%d개를 구매했습니다.\n", purchaseCount);
    }

    public static void printLottos(Lottos lottos) {
        List<Lotto> lottoGroup = lottos.getLottos();
        printResultBuyCount(lottoGroup.size());
        lottoGroup.forEach(OutputView::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printWinningMatchCount(RankResult rankResult) {
        Map<Rank, Long> result = rankResult.getRankResult();
        System.out.println("\n당첨 통계");
        System.out.println("-----------");
        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> printRankResult(rank, result.getOrDefault(rank, 0L)));
    }

    private static void printRankResult(Rank rank, Long count) {
        if (rank == Rank.MISS) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getCount()).append("개 일치");

        if (rank == Rank.SECOND) {
            sb.append(",");
        }
        sb.append(" ");
        if (rank == Rank.SECOND) {
            sb.append("보너스 볼 일치 ");
        }

        sb.append("(")
                .append(String.format("%,d원", rank.getPrize().toLong()))
                .append(") - ")
                .append(count)
                .append("개");
        System.out.println(sb);
    }

    public static void printRateOfEarning(double rateOfEarning) {
        double roundedRate = Math.round(rateOfEarning * 10000.0) / 100.0;
        String message = "총 수익률은 %.1f%%입니다.";
        System.out.printf(message, roundedRate);
    }
}
