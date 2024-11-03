package lotto.model.lotto;

import lotto.exception.LottoException;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumberCount(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoConstant.NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoException.INVALID_COUNT.getMessage());
        }
    }

    public List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }

}
