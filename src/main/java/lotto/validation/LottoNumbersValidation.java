package lotto.validation;

import lotto.exception.LottoArgumentException;
import lotto.exception.LottoErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersValidation {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public static void isValidateLottoNumbers(List<Integer> lottoNumbers) {
        checkSizeOfLottoNumbers(lottoNumbers);

        checkValidRangeNumbers(lottoNumbers);

        checkDuplicateNumbers(lottoNumbers);
    }

    private static void checkSizeOfLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new LottoArgumentException(LottoErrorMessage.LOTTO_NUMBERS_COUNT_ERROR);
        }
    }

    private static void checkValidRangeNumbers(List<Integer> lottoNumbers) {
        if (!lottoNumbers.stream().allMatch(lottoNumber
                -> MINIMUM_NUMBER <= lottoNumber && lottoNumber <= MAXIMUM_NUMBER)) {
            throw new LottoArgumentException(LottoErrorMessage.NUMBERS_RANGE_ERROR);
        }
    }

    private static void checkDuplicateNumbers(List<Integer> lottoNumbers) {
        Set<Integer> duplicateNumbers = new HashSet<>();
        if (lottoNumbers.stream().anyMatch(lottoNumber -> !duplicateNumbers.add(lottoNumber))) {
            throw new LottoArgumentException(LottoErrorMessage.DUPLICATE_LOTTO_NUMBERS_ERROR);
        }
    }

    public static void isValidateBonusNumber(int bonusNumber, List<Integer> winNumbers) {
        checkValidRangeBonusNumber(bonusNumber);

        checkDuplicateWinNumbersAndBonusNumber(bonusNumber, winNumbers);
    }

    private static void checkValidRangeBonusNumber(int bonusNumber) {
        if (bonusNumber < MINIMUM_NUMBER || MAXIMUM_NUMBER < bonusNumber) {
            throw new LottoArgumentException(LottoErrorMessage.NUMBERS_RANGE_ERROR);
        }
    }

    private static void checkDuplicateWinNumbersAndBonusNumber(int bonusNumber, List<Integer> winNumbers) {
        if(winNumbers.stream().anyMatch(number -> number == bonusNumber)) {
            throw new LottoArgumentException(LottoErrorMessage.DUPLICATE_WIN_BONUS_NUMBER_ERROR);
        }
    }
}
