package view;

import domain.LottoRank;

import java.util.Map;

public class OutputView {

    public void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printResults(Map<LottoRank, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");

        // 결과 출력
        results.forEach((rank, count) -> {
            String resultMessage = String.format("%d개 일치 (%s원) - %d개",
                    rank.getMatchCount(),
                    rank.getPrize(),
                    count);
            System.out.println(resultMessage);
        });
    }

    public void printTotalYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}
