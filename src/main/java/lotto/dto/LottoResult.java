package lotto.dto;

import lotto.constant.Rank;

public class LottoResult {
    private final Rank rank;
    private final int matchCount;

    private LottoResult(Rank rank, int matchCount) {
        this.rank = rank;
        this.matchCount = matchCount;
    }

    public static LottoResult of(Rank rank, int matchCount) {
        return new LottoResult(rank, matchCount);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Rank getRank() {
        return rank;
    }
}
