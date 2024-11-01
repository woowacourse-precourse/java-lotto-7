package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.enums.Rank;

public class OutputView {

    private final NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.stream()
                .map(Lotto::getLotto)
                .forEach(System.out::println);
    }

    public void printWinningStatistics(List<Rank> results, int totalCost) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<Rank, Long> rankCount = results.stream()
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));

        Stream.of(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> System.out.printf("%s (%s원) - %d개\n",
                        getMatchDescription(rank),
                        numberFormat.format(rank.getAmount()),
                        rankCount.getOrDefault(rank, 0L)));
    }

    public void printProfitRate(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
    }

    private String getMatchDescription(Rank rank) {
        if (rank.getBonusCheck()) {
            return String.format("%d개 일치, 보너스 볼 일치", rank.getCorrectCount());
        }
        return String.format("%d개 일치", rank.getCorrectCount());
    }
}
