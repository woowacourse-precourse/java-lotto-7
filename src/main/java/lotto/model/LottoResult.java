package lotto.model;

public class LottoResult {
    private final int[] rankCount;
    private final int[] prizeMoney;

    public LottoResult(int[] rankCount, int[] prizeMoney) {
        this.rankCount = rankCount;
        this.prizeMoney = prizeMoney;
    }

    public int[] getRankCount() {
        return rankCount;
    }

    public int[] getPrizeMoney() {
        return prizeMoney;
    }
}
