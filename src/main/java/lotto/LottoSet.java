package lotto;

import java.util.List;

public class LottoSet {
    private List<Lotto> lottoSet;

    public LottoSet(List<Lotto> lottoSet) {
        this.lottoSet = lottoSet;
    }

    public int getNumberOfLottoSet() {
        return lottoSet.size();
    }
}
