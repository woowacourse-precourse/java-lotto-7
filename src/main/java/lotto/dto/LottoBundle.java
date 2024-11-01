package lotto.dto;

import java.util.List;

public class LottoBundle {
    private List<LottoNumbers> lottoNumbers;

    public LottoBundle(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }
}
