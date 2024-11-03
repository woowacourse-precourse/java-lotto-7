package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class OutputView {

    public static void printPurchasedLotto(List<Lotto> lottos){
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printResult(LottoResult result, int purchaseAmount){
        System.out.println("당첨 통계\n---");
        Map<LottoRank, Integer> rankCount = result.getRankCount();
        rankCount.forEach((rank, count) -> {
            if (rank != LottoRank.NONE){
                System.out.printf("%d개 일치 (%d)원 - %d개%n",
                        rank.getMatchCount(), rank.getPrize(), count);
            }
        });
        double profitRate = calculateProfitRate(result.getTotalPrize(), purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public static double calculateProfitRate(long totalPrize, int purchaseAmount){
        return ((double) totalPrize / purchaseAmount) * 100;
    }
}
