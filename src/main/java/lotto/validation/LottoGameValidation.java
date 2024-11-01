package lotto.validation;

import java.util.List;

import static lotto.message.ErrorMessage.*;
import static lotto.Constants.*;
public class LottoGameValidation {

    public static void validateWinningNumbers(List<Integer> winningNumbers){
        validateWinningNumbersCount(winningNumbers);
        validateWinningNumbersDuplicated(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
    }

    private static boolean isNumberOutOfRange(int number){
        return number < LOTTO_MIN_NUM || number >= LOTTO_MAX_NUM;
    }

    private static void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if(isSizeNotEqualToSix(winningNumbers)){
            throw new IllegalArgumentException(WINNING_NUMBERS_NOT_FIT_COUNT.getMessage());
        }
    }

    private static boolean isSizeNotEqualToSix(List<Integer> winningNumbers){
        return winningNumbers.size() != LOTTO_PICK_NUM;
    }

    private static void validateWinningNumbersDuplicated(List<Integer> winningNumbers) {
        if(hasDuplicate(winningNumbers)){
            throw new IllegalArgumentException(WINNING_NUMBERS_HAS_DUPLICATE.getMessage());
        }
    }

    private static <T> boolean hasDuplicate(List<T> items){
        return items.size() != items.stream().distinct().count();
    }

    private static void validateWinningNumbersRange(List<Integer> winningNumbers) {
        for(int number : winningNumbers){
            if (isNumberOutOfRange(number)){
                throw new IllegalArgumentException(WINNING_NUMBERS_OUT_OF_RANGE.getMessage());
            }
        }
    }

}
