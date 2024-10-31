package lotto.model;

public class MatchingRecord {
    private final Rank rank;
    private int lottoQuantity;

    public MatchingRecord(Rank rank) {
        this.rank = rank;
        lottoQuantity = 0;
    }

    public void increaseLottoQuantity() {
        lottoQuantity++;
    }

    public Rank getRank() {
        return this.rank;
    }

    public int getLottoQuantity() {
        return this.lottoQuantity;
    }
}
