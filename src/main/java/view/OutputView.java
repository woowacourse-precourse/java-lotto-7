package view;

import lotto.model.PrizeRank;
import lotto.model.PrizeStatistics;
import lotto.model.lotto.Lotto;

import java.text.NumberFormat;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;

public class OutputView {

    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.", lottos.size());
        printLineSeparate();

        lottos.forEach(this::printLotto);
        System.out.println();
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    private void printLineSeparate() {
        System.out.print(System.lineSeparator());
    }

    public void printWinning(PrizeStatistics prizeStatistics) {
        printLineSeparate();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (PrizeRank prizeRank : EnumSet.of(PrizeRank.FIFTH, PrizeRank.FOURTH, PrizeRank.THIRD, PrizeRank.SECOND, PrizeRank.FIRST)) {
            int matchCount = prizeRank.getMatchCount();
            int winningMoney = prizeRank.getWinningMoney();
            int count = prizeStatistics.getStatistics().get(prizeRank);

            String formattedWinningMoney = formatWithComma(winningMoney);

            if (prizeRank == PrizeRank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", matchCount, formattedWinningMoney, count);
            } else {
                System.out.printf("%d개 일치 (%s원) - %d개%n", matchCount, formattedWinningMoney, count);
            }
        }
    }

    private String formatWithComma(int money) {
        return NumberFormat.getInstance(Locale.KOREA).format(money);
    }

    public void printRatio(double ratio) {
        System.out.printf("총 수익률은 %.1f%%입니다.", ratio);
    }
}
