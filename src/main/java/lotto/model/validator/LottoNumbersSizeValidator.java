package lotto.model.validator;

import static lotto.exception.InvalidLottoNumberException.INVALID_LOTTO_NUMBER_MESSAGE;

import java.util.List;
import lotto.util.LottoConstants;

public class LottoNumbersSizeValidator {
    private final List<Integer> lottoNumbers;

    public LottoNumbersSizeValidator(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void validate() {
        if (lottoNumbers.size() != LottoConstants.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_MESSAGE);
        }
    }
}
