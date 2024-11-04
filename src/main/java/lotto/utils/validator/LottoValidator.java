package lotto.utils.validator;

import lotto.utils.constants.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator implements Validator<List<Integer>> {
    private static final String LOTTO_NUMBER_SIZE_IS_SIX = ErrorMessage + "로또 번호는 6개의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_NO_DUPLICATE = ErrorMessage + "로또 번호는 중복되면 안됩니다.";
    private static final String LOTTO_NUMBER_IS_RANGE = ErrorMessage + "로또 번호의 범위는 1~45 입니다.";

    @Override
    public void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateUniqueness(numbers);
        validateRange(numbers);
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> existingNumbers) {
        validateRange(bonusNumber);
        validateNoDuplicate(bonusNumber, existingNumbers);
    }

    public void validateRange(int number) {
        if (number < LottoConstants.MIN_LOTTO_NUMBER || number > LottoConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_RANGE);
        }
    }

    public void validateNoDuplicate(int number, List<Integer> existingNumbers) {
        if (existingNumbers.contains(number)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NO_DUPLICATE);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_IS_SIX);
        }
    }

    private void validateUniqueness(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NO_DUPLICATE);
        }
    }

    private void validateRange(List<Integer> lottoNumbers) {
        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber < LottoConstants.MIN_LOTTO_NUMBER || lottoNumber > LottoConstants.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(LOTTO_NUMBER_IS_RANGE);
            }
        }
    }
}

