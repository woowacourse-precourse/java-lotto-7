package lotto.model;

public enum LottoResult {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000, true),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final int prize;
    private final boolean bonusMatch;
    private int winCount = 0;

    LottoResult(int matchCount, int prize) {
        this(matchCount, prize, false);
    }

    LottoResult(int matchCount, int prize, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getWinCount() {
        return winCount;
    }

    public void incrementWinCount() {
        this.winCount++;
    }

    @Override
    public String toString() {
        if (bonusMatch) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원)", matchCount, prize);
        }
        return String.format("%d개 일치 (%,d원)", matchCount, prize);
    }
}
