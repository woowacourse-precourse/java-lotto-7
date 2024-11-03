package lotto.dto.result;

import static lotto.exception.ErrorMessage.*;

import lotto.exception.CustomIllegalArgumentException;

import java.util.HashSet;
import java.util.List;

public record WinningNumbers(List<Integer> lottoNumbers) {

    public WinningNumbers {
        validateLottoNumbers(lottoNumbers);
    }

    private void validateLottoNumbers(List<Integer> lottoNumbers) {
        validateLottoNumbersNotNull(lottoNumbers);
        validateLottoNumbersNotEmpty(lottoNumbers);
        validateNoDuplicates(lottoNumbers);
    }

    private void validateLottoNumbersNotNull(List<Integer> lottoNumbers) {
        if (lottoNumbers == null) {
            throw CustomIllegalArgumentException.from(NULL_LOTTO_NUMBERS);
        }
    }

    private void validateLottoNumbersNotEmpty(List<Integer> lottoNumbers) {
        if (lottoNumbers.isEmpty()) {
            throw CustomIllegalArgumentException.from(EMPTY_LOTTO_NUMBERS);
        }
    }

    private void validateNoDuplicates(List<Integer> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() != lottoNumbers.size()) {
            throw CustomIllegalArgumentException.from(DUPLICATE_NUMBER_IN_WINNING_NUMBERS);
        }
    }
}
