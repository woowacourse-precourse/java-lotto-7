package lotto.dto;

import lotto.exception.CustomIllegalArgumentException;
import static lotto.exception.ErrorMessage.*;

public record LottoNumbersInput(String lottoNumbers) {

    public LottoNumbersInput {
        validate(lottoNumbers);
    }

    private void validate(String lottoNumbers) {
        validateLottoNumbersNotNull(lottoNumbers);
        validateLottoNumbersNotEmpty(lottoNumbers);
    }

    private void validateLottoNumbersNotNull(String lottoNumbers) {
        if (lottoNumbers == null) {
            throw CustomIllegalArgumentException.from(NULL_INPUT);
        }
    }

    private void validateLottoNumbersNotEmpty(String lottoNumbers) {
        if (lottoNumbers.isEmpty()) {
            throw CustomIllegalArgumentException.from(EMPTY_INPUT);
        }
    }
}
