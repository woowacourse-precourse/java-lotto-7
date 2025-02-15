package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.Constants;
import lotto.common.ErrorMessages;

public class Validator {
    public void isInputPriceValid(String price) {
        if (price == null || price.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.PRICE_NULL_BLANK);
        } else if (!price.matches(Constants.INPUT_REGEX)) {
            throw new IllegalArgumentException(ErrorMessages.PRICE_NUMBER_ONLY);
        } else if (Integer.parseInt(price) < 0) {
            throw new IllegalArgumentException((ErrorMessages.PRICE_POSITIVE_ONLY));
        } else if (Integer.parseInt(price) % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.PRICE_RANGE);
        }
    }

    public void isBonusNumberValid(String bonusNumber) {
        if (bonusNumber == null || bonusNumber.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NULL_BLANK);
        } else if (!bonusNumber.matches(Constants.INPUT_REGEX)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_ONLY);
        } else if (Integer.parseInt(bonusNumber) < Constants.RANDOM_MIN_NUM
                || Integer.parseInt(bonusNumber) > Constants.RANDOM_MAX_NUM) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_RANGE);
        }
    }

    public void isBonusNumberDuplicated(String bonusNumber, List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_LOTTO_DUPLICATED);
        }
    }

    public void isLottoNumberValid(String lottoNumber) {
        if (lottoNumber == null || lottoNumber.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NULL_BLANK);
        } else if (!lottoNumber.matches(Constants.INPUT_REGEX)) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_ONLY);
        } else if (Integer.parseInt(lottoNumber) < Constants.RANDOM_MIN_NUM
                || Integer.parseInt(lottoNumber) > Constants.RANDOM_MAX_NUM) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_RANGE);
        }
    }

    public void isLottoNumbersValid(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_COUNT);
        }
        Set<Integer> removeDuplicates = new HashSet<>(lottoNumbers);
        if(removeDuplicates.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_DUPLICATED);
        }
    }

}
