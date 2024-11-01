package lotto.model;

import lotto.validation.GlobalValidation;

import java.util.List;

import static lotto.Constants.*;
import static lotto.message.ErrorMessage.*;

public class WinningNumbers {
    private List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }

    public void validateWinningNumbers(List<Integer> winningNumbers){
        validateWinningNumbersCount(winningNumbers);
        validateWinningNumbersDuplicated(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
    }

    private void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if(isSizeNotEqualToSix(winningNumbers)){
            throw new IllegalArgumentException(WINNING_NUMBERS_NOT_FIT_COUNT.getMessage());
        }
    }

    private boolean isSizeNotEqualToSix(List<Integer> winningNumbers){
        return winningNumbers.size() != LOTTO_PICK_NUM;
    }

    private void validateWinningNumbersDuplicated(List<Integer> winningNumbers) {
        if(hasDuplicate(winningNumbers)){
            throw new IllegalArgumentException(WINNING_NUMBERS_HAS_DUPLICATE.getMessage());
        }
    }

    private <T> boolean hasDuplicate(List<T> items){
        return items.size() != items.stream().distinct().count();
    }

    private void validateWinningNumbersRange(List<Integer> winningNumbers) {
        for(int number : winningNumbers){
            if (GlobalValidation.isLottoNumberOutOfRange(number)){
                throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }
}
