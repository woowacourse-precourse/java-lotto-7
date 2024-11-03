package lotto.validation;

import lotto.message.ErrorMessage;

import java.util.List;

public class LottoValidator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LIMIT_LOTTO_NUMBER_SIZE = 6;

    public static void checkLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != LIMIT_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    public static void checkLottoNumberRange(List<Integer> numbers){
        for(int number : numbers){
            if(number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER){
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

}
