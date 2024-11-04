package lotto;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(Buyer buyer, LottoGame lottoGame) {
        LottoResult result = lottoGame.calculateResult(buyer.getPurchasedLottos());
        Map<Rank, Integer> resultMap = result.getResultMap();

        System.out.println("\n당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }
            String matchInfo = rank.getMatchCount() + "개 일치";
            if (rank == Rank.SECOND) {
                matchInfo += ", 보너스 볼 일치";
            }
            System.out.println(matchInfo + " (" + rank.getPrize() + "원) - " + resultMap.getOrDefault(rank, 0) + "개");
        }

        int totalPrize = result.calculateTotalPrize();
        double profitRate = (double) totalPrize / buyer.getPurchaseAmount() * 100;
        System.out.println("총 수익률은 " + String.format("%.2f", profitRate) + "%입니다.");
    }
}
