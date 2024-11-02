package lotto.dto;

import static lotto.exception.ErrorMessage.*;

import lotto.exception.CustomIllegalArgumentException;

import java.util.HashSet;
import java.util.List;

public record WinningNumbers(List<Integer> lottoNumbers, int bonusNumber) {

    public WinningNumbers {
        validateBonusNumberNotInLottoNumbers(lottoNumbers, bonusNumber);
    }

    private void validateBonusNumberNotInLottoNumbers(List<Integer> lottoNumbers, int bonusNumber) {
        if (new HashSet<>(lottoNumbers).contains(bonusNumber)) {
            throw CustomIllegalArgumentException.from(BONUS_NUMBER_DUPLICATE);
        }
    }
}
