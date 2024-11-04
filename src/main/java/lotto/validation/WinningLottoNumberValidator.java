package lotto.validation;

import lotto.exception.WinningLottoNumberException;

import java.util.HashSet;
import java.util.List;

import static lotto.common.constant.ErrorMessage.*;

public class WinningLottoNumberValidator {
    public static void validateWinningLottoNumber(List<Integer> winningNumbers){
        throwExceptionIfDuplicateNumber(winningNumbers);
    }

    private static void throwExceptionIfDuplicateNumber(List<Integer> winningNumbers){
        if(winningNumbers.size() != new HashSet<>(winningNumbers).size()){
            throw new WinningLottoNumberException(THERE_IS_DUPLICATE_NUMBER_IN_WINNING_LOTTO);
        }
    }
}
