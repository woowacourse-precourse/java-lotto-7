package lotto.presentation.view;

import static lotto.domain.Rank.DRAW;
import static lotto.domain.Rank.SECOND;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
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

    public static void renderBlankLine() {
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

        String rankStatisticsText = generateRankStatistics(rankValues, ranks);
        String profitRateText = Text.PROFIT_RATE.getText(profitRate);

        System.out.print(rankStatisticsText);
        System.out.printf(profitRateText);
    }

    private static String generateRankStatistics(List<Rank> rankValues, List<Rank> ranks) {
        StringBuilder builder = new StringBuilder();
        for (Rank rankValue : rankValues) {
            String rankText = generateRankText(ranks, rankValue);
            builder.append(rankText);
        }

        return builder.toString();
    }

    private static String generateRankText(List<Rank> ranks, Rank rankValue) {
        int rankCount = countRank(rankValue, ranks);
        int rankPrize = rankValue.getPrize();
        int requiredHitCount = rankValue.getRequiredHitCount();

        if (rankValue == SECOND) {
            return Text.WIN_HISTORY_SECOND.getText(requiredHitCount, rankPrize, rankCount);
        }
        return Text.WIN_HISTORY.getText(requiredHitCount, rankPrize, rankCount);
    }

    private static int countRank(Rank rank, List<Rank> ranks) {
        return (int) ranks.stream().filter(rank::equals).count();
    }

    private enum Text {
        PROFIT_RATE(args -> String.format("총 수익률은 %.1f", args) + "%%입니다."),
        WIN_HISTORY(args -> String.format("%d개 일치 (%,d원) - %d개", args)),
        WIN_HISTORY_SECOND(args -> String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", args));

        private final Function<Object[], String> textSupplier;

        Text(Function<Object[], String> textSupplier) {
            this.textSupplier = textSupplier;
        }

        public String getText(Object... args) {
            return textSupplier.apply(args) + '\n';
        }
    }
}
