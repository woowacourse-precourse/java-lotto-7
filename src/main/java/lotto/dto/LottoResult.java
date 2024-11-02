package lotto.dto;

import lotto.constant.Rank;

public class LottoResult {
    private final Rank rank;
    private final int numberOfMatched;


    private LottoResult(Rank rank, int numberOfMatched) {
        this.rank = rank;
        this.numberOfMatched = numberOfMatched;
    }

    public static LottoResult of(Rank rank, int numberOfMatched) {
        return new LottoResult(rank, numberOfMatched);
    }

    public int getNumberOfMatched() {
        return numberOfMatched;
    }

    public Rank getRank() {
        return rank;
    }
}
