package lotto.View;

import lotto.domain.Lottos;
import lotto.domain.Ranking;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    public static void printNumberOfLotto(int lottoQuantity) {
        System.out.printf("%d개를 구매했습니다.\n", lottoQuantity);
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().stream()
                .forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
    }

    public static void printWinningStatistics() {
        System.out.println("당첨 통계\n---");
    }

    public static void printWinningInfo(Map<Ranking, Integer> winningInfo) {
        winningInfo.entrySet().stream()
                .filter(entry -> entry.getKey() != Ranking.LAST_PLACE)
                .forEach(entry -> {
                    if (entry.getKey() == Ranking.SECOND_PLACE) {
                        printWinningInfoWithBonus(entry);
                        return;
                    }
                    printWinningDetailsWithoutBonus(entry);
                });
    }

    private static void printWinningInfoWithBonus(Map.Entry<Ranking, Integer> entry) {
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                entry.getKey().getMatchingCount(),
                getFormattingPrice(entry.getKey().getWinningPrice()),
                entry.getValue());
    }

    private static void printWinningDetailsWithoutBonus(Map.Entry<Ranking, Integer> entry) {
        System.out.printf("%d개 일치 (%s원) - %d개\n",
                entry.getKey().getMatchingCount(),
                getFormattingPrice(entry.getKey().getWinningPrice()),
                entry.getValue());
    }

    private static String getFormattingPrice(int winningPrice) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(winningPrice);
    }

    public static void printProfit(float lottoProfit) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", lottoProfit);
    }

}
