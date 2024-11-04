package lotto.view;

import lotto.Lotto;
import lotto.domain.LottoRank;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLotto(List<Lotto> lotto) {
        System.out.println(lotto.size() + "개를 구매했습니다.");

        lotto.forEach(i ->
                System.out.println(i.getLotto().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]")))
        );

        addBlankLine();
    }

    public static void printResult(Map<LottoRank, Integer> result, int purchaseAmount) {
        System.out.println("당첨 통계\n---");
        double totalPrize = 0.0;
        for (LottoRank rank : result.keySet()) {
            String formattedPrize = NumberFormat.getInstance().format(rank.getPrize());
            totalPrize += (double) rank.getPrize() * result.get(rank);
            switch (rank) {
                case THREE_MATCH:
                    System.out.printf("3개 일치 (%s원) - %d개\n", formattedPrize, result.get(rank));
                    break;
                case FOUR_MATCH:
                    System.out.printf("4개 일치 (%s원) - %d개\n", formattedPrize, result.get(rank));
                    break;
                case FIVE_MATCH:
                    System.out.printf("5개 일치 (%s원) - %d개\n", formattedPrize, result.get(rank));
                    break;
                case FIVE_MATCH_WITH_BONUS:
                    System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개\n", formattedPrize, result.get(rank));
                    break;
                case SIX_MATCH:
                    System.out.printf("6개 일치 (%s원) - %d개\n", formattedPrize, result.get(rank));
                    break;
            }
        }
        double revenueRatio = totalPrize / (double) purchaseAmount * 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", Math.round(revenueRatio * 10) / 10.0);
    }

    private static void addBlankLine() {
        System.out.println();
    }
}
