package view;

import domain.FindWinningLotto;

import java.util.List;

public class OutputView {

    public static int countBuyingLotto(int moneyToBuyLotto) {
        System.out.printf("%d개를 구매했습니다.\n", moneyToBuyLotto / 1000);
        return moneyToBuyLotto / 1000;
    }

    public static void printLottoCollection(List<List<Integer>> lottoCollection) {
        for (List<Integer> lotto : lottoCollection) {
            System.out.println(lotto);
        }
    }

    public static void printResultStatisticMessage() {
        System.out.println("당첨 통계\n---");
    }

    public static void printResultOfStatistic() {
        for (FindWinningLotto.LottoRank rank : FindWinningLotto.LottoRank.values()) {
            if (rank == FindWinningLotto.LottoRank.FIVE_WITH_BONUS) {
                System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개\n", rank.getPrize(), rank.getCount());
            }
            if (rank != FindWinningLotto.LottoRank.FIVE_WITH_BONUS) {
                System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getMatchCount(), rank.getPrize(), rank.getCount());
            }
        }
        System.out.println();
    }

    public static void printRateOfReturn(int moneyToBuyLotto) {//
        int winningPrize = 0;

        for (FindWinningLotto.LottoRank rank : FindWinningLotto.LottoRank.values()) {
            int prize = Integer.parseInt(rank.getPrize().replace(",", ""));
            winningPrize += prize * rank.getCount();
        }
        double rateOfReturn = ((double) winningPrize / moneyToBuyLotto) * 100;

        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}
