package lotto.dto.result;

import static lotto.exception.ErrorMessage.*;

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
            throw new NullPointerException(NULL_LOTTO_NUMBERS.getMessage());
        }
    }

    private void validateLottoNumbersNotEmpty(List<Integer> lottoNumbers) {
        if (lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LOTTO_NUMBERS.getMessage());
        }
    }

    private void validateNoDuplicates(List<Integer> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_IN_WINNING_NUMBERS.getMessage());
        }
    }
}
