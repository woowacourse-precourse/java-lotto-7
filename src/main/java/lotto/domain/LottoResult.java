package lotto.domain;

import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> lottoResultForm;

    public LottoResult(Map<LottoRank, Integer> lottoResultForm) {
        this.lottoResultForm = lottoResultForm;
    }

    public int findCountByLottoRank(LottoRank lottoRank) {
        return lottoResultForm.get(lottoRank);
    }

    public void addCountByLottoRank(LottoRank lottoRank) {
        lottoResultForm.put(lottoRank, lottoResultForm.get(lottoRank) + 1);
    }
}