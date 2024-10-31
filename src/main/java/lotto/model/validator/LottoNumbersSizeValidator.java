package lotto.model.validator;

import static lotto.exception.InvalidLottoNumberException.INVALID_LOTTO_NUMBERS;

import java.util.List;
import lotto.util.LottoConstants;

public class LottoNumbersSizeValidator implements Validator{
    private final List<Integer> lottoNumbers;

    public LottoNumbersSizeValidator(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public void validate() {
        if (lottoNumbers.size() != LottoConstants.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS);
        }
    }
}
