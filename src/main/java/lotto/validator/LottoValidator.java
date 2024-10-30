package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.validator.exception.ErrorMessage;
import lotto.validator.exception.LottoException;

public class LottoValidator {
    private final static int LOTTO_LENGTH = 6;
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_MAX_NUMBER = 45;

    public static void validateProcess(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private static void validateLength(List<Integer> numbers) {
        int numbersLength = numbers.size();
        if(numbersLength != LOTTO_LENGTH) {
            throw LottoException.from(ErrorMessage.WINNING_LOTTO_IS_NOT_SIX_LENGTH);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for(int number : numbers) {
            if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                throw LottoException.from(ErrorMessage.WINNING_LOTTO_RANGE_ERROR);
            }
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for(int number : numbers) {
            if(!numberSet.add(number)) {
                throw LottoException.from(ErrorMessage.WINNING_LOTTO_DUPLICATE_ERROR);
            }
        }
    }

}
