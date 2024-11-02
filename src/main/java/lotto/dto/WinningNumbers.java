package lotto.dto;

import static lotto.exception.ErrorMessage.*;

import lotto.exception.CustomIllegalArgumentException;

import java.util.HashSet;
import java.util.List;

public record WinningNumbers(List<Integer> lottoNumbers, int bonusNumber) {

    public WinningNumbers {
        validateLottoNumbers(lottoNumbers);
        validateBonusNumber(lottoNumbers, bonusNumber);
    }

    private void validateLottoNumbers(List<Integer> lottoNumbers) {
        validateLottoNumbersNotNull(lottoNumbers);
        validateLottoNumbersNotEmpty(lottoNumbers);
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

    private void validateBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (new HashSet<>(lottoNumbers).contains(bonusNumber)) {
            throw CustomIllegalArgumentException.from(BONUS_NUMBER_DUPLICATE);
        }
    }
}
