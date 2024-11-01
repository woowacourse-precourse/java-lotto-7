package lotto.view.response;

import java.util.List;

public class LottoNumberResponse {

    private final List<Integer> lottoNumbers;

    private LottoNumberResponse(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumberResponse from(List<Integer> lottoNumbers) {
        return new LottoNumberResponse(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
