package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    // 각 등수에 따른 당첨 횟수를 저장하는 맵
    private final Map<Rank, Integer> rankCounts;

    // 기본 생성자
    public LottoResult() {
        rankCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0); // 모든 등수를 0으로 초기화
        }
    }

    // 등수에 따라 당첨 횟수를 업데이트
    public void updateRank(int matchCount, boolean hasBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() == matchCount && rank.isMatchBonus() == hasBonus) {
                rankCounts.put(rank, rankCounts.get(rank) + 1);
                return; // 일치하는 등수를 찾았으면 메서드를 종료
            }
        }
    }

    // 전체 당첨 상금 합산
    public int calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getPrizeMoney())
                .sum();
    }

    // 총 상금 반환
    public int getTotalPrize() {
        return calculateTotalPrize(); // 상금 계산 메서드 호출
    }

    // 당첨 결과 출력
    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rankCounts.get(rank) > 0) {
                System.out.printf("%d개 일치 (%d원) - %d개\n", rank.getMatchCount(), rank.getPrizeMoney(), rankCounts.get(rank));
            }
        }
    }
}