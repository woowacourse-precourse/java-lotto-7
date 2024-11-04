package lotto.domain;

import java.util.List;

public class LottoMatch {

    private final List<LottoRank> ranks;

    public LottoMatch(List<LottoRank> ranks) {
        this.ranks = ranks;
    }

    public List<LottoRank> getRanks() {
        return ranks;
    }
}
