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
        GlobalValidation.validateLottoNumbersRange(winningNumbers);
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
        if(GlobalValidation.hasDuplicate(winningNumbers)){
            throw new IllegalArgumentException(WINNING_NUMBERS_HAS_DUPLICATE.getMessage());
        }
    }

}
