package lotto.validation;

import lotto.exception.WinningLottoNumberException;

import java.util.HashSet;
import java.util.List;

import static lotto.common.constant.ErrorMessage.*;

public class WinningLottoNumberValidator {
    public static void validateWinningLottoNumber(List<Integer> winningNumbers){
        throwExceptionIfDuplicateNumber(winningNumbers);
        throwExceptionIfNumberIsNotValid(winningNumbers);
    }

    public static void throwExceptionPrefixOrSuffixIsComma(String userInputWinningNumbers){
        if(userInputWinningNumbers.startsWith(",") || userInputWinningNumbers.endsWith(",")){
            throw new WinningLottoNumberException(WINNING_LOTTO_MUST_NOT_START_END_WITH_COMMA);
        }
    }

    private static void throwExceptionIfDuplicateNumber(List<Integer> winningNumbers){
        if(winningNumbers.size() != new HashSet<>(winningNumbers).size()){
            throw new WinningLottoNumberException(THERE_IS_DUPLICATE_NUMBER_IN_WINNING_LOTTO);
        }
    }

    private static void throwExceptionIfNumberIsNotValid(List<Integer> winningNumbers){
        boolean isValid = winningNumbers.stream()
                .allMatch(number -> number > 0 && number <= 45);

        if(!isValid){
            throw new WinningLottoNumberException(THERE_IS_INVALID_NUMBER_IN_WINNING_LOTTO);
        }
    }
}
