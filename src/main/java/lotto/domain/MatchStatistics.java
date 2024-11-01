package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MatchStatistics {
    private final Map<String, Integer> matchResults = new LinkedHashMap<>(); // LinkedHashMap 사용
    private double totalEarnings;
    private double totalSpent;

    public MatchStatistics() {
        matchResults.put("3개 일치 (5,000원)", 0);
        matchResults.put("4개 일치 (50,000원)", 0);
        matchResults.put("5개 일치 (1,500,000원)", 0);
        matchResults.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        matchResults.put("6개 일치 (2,000,000,000원)", 0);
    }

    public void addMatchResult(String matchType, int count) {
        matchResults.put(matchType, matchResults.get(matchType) + count);
    }

    public void setTotalSpent(double amount) {
        this.totalSpent = amount;
    }

    public void addTotalEarnings(double amount) {
        this.totalEarnings += amount;
    }

    public double getProfitRate() {
        return totalSpent > 0 ? (totalEarnings / totalSpent) * 100 : 0;
    }

    public Map<String, Integer> getMatchResults() {
        return matchResults;
    }

    public void printMatchResults() {
        System.out.println("당첨 통계");
        System.out.println("---");
        matchResults.forEach((key, value) -> {
            System.out.printf("%s - %d개%n", key, value);
        });
        System.out.printf("총 수익률: %.1f%%", getProfitRate());
    }

    public void calculateMatches(List<Lotto> tickets, WinningNumber winningNumber) {
        for (Lotto ticket : tickets) {
            int matchCount = (int) ticket.getNumbers().stream()
                    .filter(winningNumber.getWinNumbers()::contains)
                    .count();
            boolean bonusMatch = ticket.getNumbers().contains(winningNumber.getBonusNumber());

            if (matchCount == 6) {
                addMatchResult("6개 일치 (2,000,000,000원)", 1);
            } else if (matchCount == 5) {
                if (bonusMatch) {
                    addMatchResult("5개 일치, 보너스 볼 일치 (30,000,000원)", 1);
                } else {
                    addMatchResult("5개 일치 (1,500,000원)", 1);
                }
            } else if (matchCount == 4) {
                addMatchResult("4개 일치 (50,000원)", 1);
            } else if (matchCount == 3) {
                addMatchResult("3개 일치 (5,000원)", 1);
            }
        }
    }
}
