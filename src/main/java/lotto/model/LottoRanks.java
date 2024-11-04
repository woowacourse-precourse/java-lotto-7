package lotto.model;

import java.util.List;

import lotto.utils.LottoRank;

public class LottoRanks {
    List<LottoRank> result;

    public LottoRanks(List<LottoRank> result) {
        this.result = result;
    }

    public List<LottoRank> getLottoRanks() {
        return result;
    }
}
