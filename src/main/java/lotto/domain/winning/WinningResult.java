package lotto.domain.winning;

public class WinningResult {
    private final Rank rank;

    public WinningResult(Rank rank) {
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public int getPrize() {
        return rank.getPrize();
    }

    public String getMessage() {
        return rank.getMessage();
    }
}