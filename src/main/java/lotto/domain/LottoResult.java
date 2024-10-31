package lotto.domain;

public class LottoResult {
    private final Rank rank;

    public LottoResult(Rank rank) {
        this.rank = rank;
    }

    public int getWinnings() {
        return rank.getWinnings();
    }

    public Rank getRank() {
        return rank;
    }
}