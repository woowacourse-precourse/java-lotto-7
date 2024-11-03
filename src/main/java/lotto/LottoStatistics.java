package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private final Map<LottoRank, Integer> rankCountMap = new HashMap<>();

    public LottoStatistics() {
        // 모든 등수의 개수를 0으로 초기화
        for (LottoRank rank : LottoRank.values()) {
            rankCountMap.put(rank, 0);
        }
    }

    // 로또 티켓의 목록과 당첨 번호, 보너스 번호를 받아 통계를 계산
    public void calculateStatistics(
            List<Lotto> tickets, Lotto winningNumbers, int bonusNumber) {
        for (Lotto ticket : tickets) {
            int matchCount = MatchCounter.getMatchCount(ticket, winningNumbers);
            boolean hasBonus = MatchCounter.checkBonus(ticket, bonusNumber);

            // 매칭된 등수를 가져옴
            LottoRank rank = LottoRank.getRank(matchCount, hasBonus);
            rankCountMap.put(rank, rankCountMap.get(rank) + 1); // 해당 등수의 개수 증가
        }
    }

    // 당첨 결과 출력
    public void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", rankCountMap.get(LottoRank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", rankCountMap.get(LottoRank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", rankCountMap.get(LottoRank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", rankCountMap.get(LottoRank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", rankCountMap.get(LottoRank.FIRST));
    }

    // 총 수익률 계산
    public void getTotalPrize(int totalInvestment) {
        int totalPrize = 0;
        double earningRate = 0.0;

        for (Map.Entry<LottoRank, Integer> entry : rankCountMap.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue(); // 각 등수별 당첨금과 개수를 곱하여 총 수익 금액 계산
        }

        earningRate =  ((double) totalPrize) / totalInvestment * 100; // 수익률 계산

        // 소수 둘째 자리에서 반올림
        BigDecimal bd = new BigDecimal(earningRate);
        bd = bd.setScale(1, RoundingMode.HALF_UP); // 둘째 자리에서 반올림

        System.out.print("총 수익률은 " + bd + "%입니다.\n"); // 소수 둘째 자리에서 반올림한 수익률 출력
    }
}