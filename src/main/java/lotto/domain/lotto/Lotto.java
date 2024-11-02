package lotto.domain.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.constant.Constants;
import lotto.common.exception.DuplicateLottoNumberException;
import lotto.common.exception.InvalidLottoSizeException;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers.size());
        validateDuplicate(lottoNumbers);
    }

    private void validateSize(int lottoSize) {
        if (lottoSize != Constants.LOTTO_SIZE) {
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
