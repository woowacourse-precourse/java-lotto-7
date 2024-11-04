package lotto.validation;

import lotto.enumValue.ExceptionMessage;

import java.util.List;

public class BonusNumberValidation {
    public static void duplicateChecker(int bonusNumber, List<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_DUPLICATE.getErrorDescription());
        }
    }
}
