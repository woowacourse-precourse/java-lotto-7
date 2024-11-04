package lotto.model.lotto;

import lotto.exception.LottoException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers);
        validateLottoNumberDuplication(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private void validateLottoNumberCount(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoConstant.NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoException.INVALID_COUNT.getMessage());
        }
    }

    private void validateLottoNumberDuplication(List<Integer> lottoNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
        if (uniqueNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(LottoException.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }

}
