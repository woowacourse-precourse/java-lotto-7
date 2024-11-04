package lotto.validator;

import lotto.exception.ExceptionMessages;

import java.util.List;

public class LottoValidator {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;

    public void validateLottoRange(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ExceptionMessages.LOTTO_NUMBER_RANGE_ERROR + number);
            }
        }
    }

    public void validateBonusLottoRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessages.LOTTO_NUMBER_RANGE_ERROR + bonusNumber);
        }
    }

    public void validateBonusNumberInLottoNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessages.BONUS_LOTTO_NUMBER_IN_LOTTO_NUMBERS_ERROR);
        }
    }

    public void validateLottoNumbersDuplication(List<Integer> lottoNumbers) {
        long uniqueCount = lottoNumbers.stream().distinct().count();
        if (uniqueCount != lottoNumbers.size()) {
            throw new IllegalArgumentException(ExceptionMessages.LOTTO_NUMBER_DUPLICATION_ERROR);
        }
    }

    public void validateLottoNumbersSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessages.LOTTO_NUMBER_COUNT_ERROR);
        }
    }
}
