package lotto.validation;

import lotto.exception.WinningLottoNumberException;

import java.util.HashSet;
import java.util.List;

import static lotto.common.constant.ErrorMessage.*;
import static lotto.common.constant.LottoInfo.DEFAULT_LOTTO;

public class WinningLottoNumberValidator {

    private static final String defaultDelimiter = ",";

    private WinningLottoNumberValidator(){
    }

    public static void validateWinningLottoNumber(List<Integer> winningNumbers){
        throwExceptionIfDuplicateNumber(winningNumbers);
        throwExceptionIfNumberIsNotValid(winningNumbers);
    }

    public static void throwExceptionPrefixOrSuffixIsComma(String userInputWinningNumbers){
        if(userInputWinningNumbers.startsWith(defaultDelimiter) || userInputWinningNumbers.endsWith(defaultDelimiter)){
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
                .allMatch(number -> number >= DEFAULT_LOTTO.getLowBoundOfLottoNumber() && number <= DEFAULT_LOTTO.getHighBoundOfLottoNumber());

        if(!isValid){
            throw new WinningLottoNumberException(THERE_IS_INVALID_NUMBER_IN_WINNING_LOTTO);
        }
    }
}
