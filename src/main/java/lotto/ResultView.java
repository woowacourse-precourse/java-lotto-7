package lotto;

import java.util.List;
import java.util.Map;


public class ResultView {
    public static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println();
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(Buyer buyer, LottoGame lottoGame) {
        LottoResult result = lottoGame.calculateResult(buyer.getPurchasedLottos());
        Map<Rank, Integer> resultMap = result.getResultMap();

        System.out.println("\n당첨 통계");
        System.out.println("---");

        // Rank 열거형을 오름차순으로 정렬하여 출력
        Rank[] sortedRanks = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
        for (Rank rank : sortedRanks) {
            String matchInfo = rank.getMatchCount() + "개 일치";
            if (rank == Rank.SECOND) {
                matchInfo += ", 보너스 볼 일치";
            }
            // 상금 금액에 천 단위 구분 기호 추가
            String formattedPrize = String.format("%,d", rank.getPrize());
            System.out.println(matchInfo + " (" + formattedPrize + "원) - " + resultMap.getOrDefault(rank, 0) + "개");
        }

        // 수익률 계산 및 반올림 처리
        int totalPrize = result.calculateTotalPrize();
        double profitRate = (double) totalPrize / buyer.getPurchaseAmount() * 100;
        profitRate = Math.round(profitRate * 10.0) / 10.0;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }


}
