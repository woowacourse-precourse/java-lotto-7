package lotto;

public class LottoResult {

    private final int totalWinnings;
    private final int[] rankCount;

    public LottoResult(int totalWinnings, int[] rankCount) {
        this.totalWinnings = totalWinnings;
        this.rankCount = rankCount;
    }

    public int getTotalWinnings() {
        return totalWinnings;
    }

    public int[] getRankCount() {
        return rankCount;
    }
}
