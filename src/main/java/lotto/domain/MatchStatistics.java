package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MatchStatistics {
    private final Map<String, Integer> matchResults = new LinkedHashMap<>();
    private double totalEarnings;
    private double totalSpent;
    private final ReturnRateCalculator returnRateCalculator;

    public MatchStatistics() {
        initializeMatchResults();
        this.returnRateCalculator = new ReturnRateCalculator();
    }

    private void initializeMatchResults() {
        for (MatchResult result : MatchResult.values()) {
            matchResults.put(result.getDescription(), 0);
        }
    }

    public void addMatchResult(MatchResult matchResult, int count) {
        matchResults.put(matchResult.getDescription(), matchResults.get(matchResult.getDescription()) + count);
        updateEarnings(matchResult, count);
    }

    private void updateEarnings(MatchResult matchResult, int count) {
        totalEarnings += matchResult.getPrize() * count;
    }

    public void setTotalSpent(double amount) {
        totalSpent += amount;
    }

    public double getProfitRate() {
        return returnRateCalculator.calculateReturnRate(totalEarnings, totalSpent);
    }

    public Map<String, Integer> getMatchResults() {
        return matchResults;
    }

    public void calculateMatches(List<Lotto> tickets, WinningNumber winningNumber) {
        for (Lotto ticket : tickets) {
            int matchCount = countMatches(ticket, winningNumber);
            boolean bonusMatch = ticket.getNumbers().contains(winningNumber.getBonusNumber());

            addMatchResultBasedOnCount(matchCount, bonusMatch);
        }
    }

    private int countMatches(Lotto ticket, WinningNumber winningNumber) {
        return (int) ticket.getNumbers().stream()
                .filter(winningNumber.getWinNumbers()::contains)
                .count();
    }

    private void addMatchResultBasedOnCount(int matchCount, boolean bonusMatch) {
        if (matchCount == MatchResult.SIX_MATCH.getMatchCount()) {
            addMatchResult(MatchResult.SIX_MATCH, 1);
            return;
        }
        if (matchCount == MatchResult.FIVE_MATCH.getMatchCount()) {
            addMatchResultForFiveMatch(bonusMatch);
            return;
        }
        if (matchCount == MatchResult.FOUR_MATCH.getMatchCount()) {
            addMatchResult(MatchResult.FOUR_MATCH, 1);
            return;
        }
        if (matchCount == MatchResult.THREE_MATCH.getMatchCount()) {
            addMatchResult(MatchResult.THREE_MATCH, 1);
        }
    }

    private void addMatchResultForFiveMatch(boolean bonusMatch) {
        if (bonusMatch) {
            addMatchResult(MatchResult.FIVE_MATCH_WITH_BONUS, 1);
            return;
        }
        addMatchResult(MatchResult.FIVE_MATCH, 1);
    }
}