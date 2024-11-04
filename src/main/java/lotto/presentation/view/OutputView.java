package lotto.presentation.view;

import static lotto.domain.Rank.DRAW;
import static lotto.domain.Rank.SECOND;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.Rank;
import lotto.service.winning.LottoStatistics;

public class OutputView {

    public static final String PURCHASED = "개를 구매했습니다.";
    public static final String STATISTICS = "당첨 통계\n---";

    public static void render(LottoPurchase purchase) {
        List<Lotto> lottos = purchase.getLottos();
        int count = lottos.size();

        System.out.println();
        System.out.println(count + PURCHASED);
        lottos.forEach(System.out::println);
        System.out.println();
    }

    public static void render(LottoStatistics statistics) {
        System.out.println();
        System.out.println(STATISTICS);

        List<Rank> ranks = statistics.getRanks();
        double profitRate = statistics.getProfitRate();

        List<Rank> rankValues = Arrays.stream(Rank.values())
            .sorted(Comparator.reverseOrder())
            .dropWhile(rank -> rank == DRAW)
            .toList();

        String text = generateRankStatistics(rankValues, ranks);
        System.out.print(text);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private static String generateRankStatistics(List<Rank> rankValues, List<Rank> ranks) {
        StringBuilder builder = new StringBuilder();
        for (Rank rankValue : rankValues) {
            int rankCount = countRank(rankValue, ranks);
            int rankPrize = rankValue.getPrize();
            int requiredHitCount = rankValue.getRequiredHitCount();

            String textOfRequiresBonus = "";
            if (rankValue == SECOND) {
                textOfRequiresBonus = ", 보너스 볼 일치";
            }

            builder.append(String.format(
                "%d개 일치%s (%,d원) - %d개%n", requiredHitCount, textOfRequiresBonus, rankPrize,
                rankCount));
        }

        return builder.toString();
    }

    private static int countRank(Rank rank, List<Rank> ranks) {
        return (int) ranks.stream().filter(rank::equals).count();
    }
}
