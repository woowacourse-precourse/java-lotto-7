package lotto.validator;

import lotto.exception.ExceptionMessages;

import java.util.List;

public class LottoValidator {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public void validateLottoRange(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ExceptionMessages.LOTTO_NUMBER_RANGE_ERROR + number);
            }
        }
    }

    public void validateLottoNumbersDuplication(List<Integer> lottoNumbers) {
        long uniqueCount = lottoNumbers.stream().distinct().count();
        if (uniqueCount != lottoNumbers.size()) {
            throw new IllegalArgumentException(ExceptionMessages.LOTTO_NUMBER_DUPLICATION_ERROR);
        }
    }
}
