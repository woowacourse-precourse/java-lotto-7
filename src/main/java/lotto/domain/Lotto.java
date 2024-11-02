package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.InvalidLottoSizeException;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers.size());
        validateDuplicate(lottoNumbers);
    }

    private void validateSize(int lottoSize) {
        if (lottoSize != LOTTO_SIZE) {
            throw new InvalidLottoSizeException(lottoSize);
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> uniqueLottoNumbers = new HashSet<>(lottoNumbers);
        if(uniqueLottoNumbers.size() != lottoNumbers.size()) {
            throw new DuplicateLottoNumberException(lottoNumbers);
        }
    }
}
