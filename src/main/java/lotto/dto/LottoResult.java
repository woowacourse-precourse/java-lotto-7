package lotto.dto;

import lotto.constant.Rank;

public class LottoResult {
    private final Rank rank;

    private LottoResult(Rank rank) {
        this.rank = rank;
    }

    public static LottoResult of(Rank rank) {
        return new LottoResult(rank);
    }

    public Rank getRank() {
        return rank;
    }
}
