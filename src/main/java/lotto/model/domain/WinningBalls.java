package lotto.model.domain;

import java.util.List;

public class WinningBalls {

    private final LottoNumbers lottoNumbers;

    public WinningBalls(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public boolean hasNumber(LottoNumber number) {
       return lottoNumbers.hasNumber(number);
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }
}
