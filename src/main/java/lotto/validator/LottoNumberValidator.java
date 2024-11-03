package lotto.validator;

import lotto.exception.LottoException;
import lotto.model.lotto.LottoConstant;

import java.util.Set;

public class LottoNumberValidator {

    public static void validateRange(Set<Integer> winningLottoNumbers){
        winningLottoNumbers.stream()
                .filter(num -> num < LottoConstant.NUMBER_START_INCLUSIVE || num > LottoConstant.NUMBER_END_INCLUSIVE)
                .findFirst()
                .ifPresent(num -> {
                    throw new IllegalArgumentException(LottoException.INVALID_RANGE.getMessage());
                });
    }

    public static void validateCount(Set<Integer> winningLottoNumbers){
        if (winningLottoNumbers.size() != LottoConstant.NUMBER_COUNT){
            throw new IllegalArgumentException(LottoException.INVALID_COUNT.getMessage());
        }
    }

}
