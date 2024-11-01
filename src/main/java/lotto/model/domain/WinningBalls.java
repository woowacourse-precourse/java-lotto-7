package lotto.model.domain;

import java.util.List;

public class WinningBalls {

    private final LottoNumbers lottoNumbers;

    public WinningBalls(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public boolean hasNumber(int number) {
       return lottoNumbers.hasNumber(number);
    }

    protected List<Integer> getNumbers() {
        return this.lottoNumbers.getNumbers();
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }
}
