package lotto;

public class LottoResult {
    private final Rank rank;
    private final int matchCount;
    private final boolean hasBonus;

    public LottoResult(Rank rank, int matchCount, boolean hasBonus) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
    }

    public Rank getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    @Override
    public String toString() {
        return "Rank: " + rank + ", Matches: " + matchCount + ", Bonus: " + (hasBonus ? "Yes" : "No");
    }
}