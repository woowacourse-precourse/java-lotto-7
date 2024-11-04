package validator;

import static view.message.ExceptionMessage.DUPLICATE_BONUS_NUMBER_EXCEPTION_MESSAGE;
import static view.message.ExceptionMessage.LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE;

import java.util.List;

public class BonusNumberValidator {

    public static void validateBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicate(lottoNumbers, bonusNumber);
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private static void validateBonusNumberDuplicate(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
