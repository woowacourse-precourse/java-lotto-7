package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts;

    // 생성자 - 모든 등수를 0으로 초기화
    public LottoResult() {
        rankCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0); // 각 등수의 당첨 개수를 0으로 초기화
        }
    }

    // 당첨 등수 카운트를 증가시키는 메서드
    public void incrementRankCount(Rank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1); // 해당 등수의 당첨 개수 증가
    }

    // 전체 당첨 상금을 계산하여 반환하는 메서드
    public int calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getPrizeMoney()) // 각 등수의 개수와 상금을 곱하여 합산
                .sum();
    }

    // 당첨 결과를 출력하는 메서드
    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) { // NONE 등수는 출력하지 않음
                int count = rankCounts.get(rank);
                System.out.printf("%s (%,d원) - %d개%n", rank.getDisplayName(), rank.getPrizeMoney(), count); // 각 등수의 이름, 상금, 당첨 개수 출력
            }
        }
    }
}
