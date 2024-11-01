/*
package lotto.model;

import java.util.HashMap;
import java.util.List;
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

    */
/*//*
/ 등수에 따라 당첨 횟수를 업데이트
    public void updateRank(int matchCount, boolean hasBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() == matchCount && rank.isMatchBonus() == hasBonus) {
                rankCounts.put(rank, rankCounts.get(rank) + 1);
                return; // 일치하는 등수를 찾았으면 메서드를 종료
            }
        }
    }*//*


    public void updateRank(int matchCount, boolean hasBonus) {
        Rank rank = Rank.of(matchCount, hasBonus);
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    // 일치하는 번호 개수 계산
    public int calculateMatchCount(List<Integer> winningNumbers, List<Integer> userNumbers) {
        int matchCount = 0;
        for (Integer number : userNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    // 등수 업데이트 메서드
    public void updateRankCounts(List<Integer> winningNumbers, List<Integer> userNumbers, Integer bonusNumber) {
        int matchCount = calculateMatchCount(winningNumbers, userNumbers);
        boolean bonusMatch = userNumbers.contains(bonusNumber);

        Rank rank = Rank.of(matchCount, bonusMatch);
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
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
                System.out.printf("%d개 일치 (%,d원) - %d개\n", rank.getMatchCount(), rank.getPrizeMoney(), rankCounts.get(rank));
            }
        }
    }
}*/


package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts;

    public LottoResult() {
        rankCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0); // 모든 등수를 0으로 초기화
        }
    }

    public void incrementRankCount(Rank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

   /* // 로또 번호와 당첨 번호를 비교하여 등수를 업데이트
    public void updateRankCounts(List<Integer> userNumbers, WinningNumbers winningNumbers) {
        int matchCount = calculateMatchCount(winningNumbers.getWinningNumbers(), userNumbers);
        boolean hasBonus = userNumbers.contains(winningNumbers.getBonusNumber());

        Rank rank = Rank.of(matchCount, hasBonus);
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
    }*/

    // 일치하는 번호 개수 계산
    private int calculateMatchCount(Set<Integer> winningNumbers, List<Integer> userNumbers) {
        int matchCount = 0;
        for (Integer number : userNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    // 전체 당첨 상금 합산
    public int calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getPrizeMoney())
                .sum();
    }

    // 총 상금 반환
    public int getTotalPrize() {
        return calculateTotalPrize();
    }

    // 당첨 결과 출력
    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                int count = rankCounts.get(rank);
                System.out.printf("%s (%,d원) - %d개%n", rank.getDisplayName(), rank.getPrizeMoney(), count);
            }
        }
    }
}
