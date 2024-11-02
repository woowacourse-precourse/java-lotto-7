package lotto.view.response;

import lotto.model.number.LottoNumbers;

import java.util.List;

public class LottoNumberResponse {

    private final List<Integer> lottoNumbers;

    private LottoNumberResponse(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers.mapToInt();
    }

    public static LottoNumberResponse from(LottoNumbers lottoNumbers) {
        return new LottoNumberResponse(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
