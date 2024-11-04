package lotto.view.response;

import lotto.model.number.LottoNumbers;

import java.util.List;

public class LottoNumberResponse {

    private final List<Integer> lottoNumbers;

    private LottoNumberResponse(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumberResponse from(LottoNumbers lottoNumbers) {
        return new LottoNumberResponse(lottoNumbers.mapToInt());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
