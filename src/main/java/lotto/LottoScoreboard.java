package lotto;

public class LottoScoreboard {
    private int threeMatches;
    private int fourMatches;
    private int fiveMatches;
    private int fiveBonusMatches;
    private int sixMatches;
    private final int totalSpent;

    public int getThreeMatches() {
        return threeMatches;
    }

    public int getFourMatches() {
        return fourMatches;
    }

    public int getFiveMatches() {
        return fiveMatches;
    }

    public int getFiveBonusMatches() {
        return fiveBonusMatches;
    }

    public int getSixMatches() {
        return sixMatches;
    }

    private int totalWinnings;

    public LottoScoreboard(int totalSpent, int totalWinnings) {
        this.totalSpent = totalSpent;
        this.totalWinnings = totalWinnings;
    }

    public void incrementThreeMatches() {
        threeMatches++;
        totalWinnings += 5000;
    }

    public void incrementFourMatches() {
        fourMatches++;
        totalWinnings += 50000;
    }

    public void incrementFiveMatches() {
        fiveMatches++;
        totalWinnings += 1500000;
    }

    public void incrementFiveBonusMatches() {
        fiveBonusMatches++;
        totalWinnings += 30000000;
    }

    public void incrementSixMatches() {
        sixMatches++;
        totalWinnings += 2000000000;
    }

    public String calculateTotalProfit() {
        double profit = ((double) totalWinnings / totalSpent) * 100;
        return String.format("%.1f%%", Math.round(profit * 10.0) / 10.0);
    }

    public void calculateIncrementNumber(int matchCount, boolean bonusMatch) {
        if (matchCount == 3) {
            incrementThreeMatches();
        }
        if (matchCount == 4) {
            incrementFourMatches();
        }
        if (matchCount == 5 && bonusMatch) {
            incrementFiveBonusMatches();
        }
        if (matchCount == 5) {
            incrementFiveMatches();
        }
        if (matchCount == 6) {
            incrementSixMatches();
        }

    }

}

