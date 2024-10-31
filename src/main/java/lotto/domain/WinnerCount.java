package lotto.domain;

public class WinnerCount {

    private final int matchedCount;
    private final boolean hasBonus;

    public WinnerCount(int matchedCount, boolean hasBonus) {
        this.matchedCount = matchedCount;
        this.hasBonus = hasBonus;
    }

    public static WinnerCount of(int winnerCount, boolean hasBonus) {
        return new WinnerCount(winnerCount, hasBonus);
    }

    protected Integer calculateReward() {
        if (matchedCount == 6) {
            return 2000000000;
        }

        if (matchedCount == 5 && hasBonus) {
            return 30000000;
        }

        int totalWins = calculateTotalWins();

        if (totalWins == 5) {
            return 1500000;
        }

        if (totalWins == 4) {
            return 50000;
        }

        if (totalWins == 3) {
            return 5000;
        }

        return 0;
    }

    private int calculateTotalWins() {
        int matchedCountWithBonus = matchedCount;

        if (hasBonus) {
            matchedCountWithBonus += 1;
        }

        return matchedCountWithBonus;
    }

}
