package lotto.model.validator;

import static lotto.model.lotto.lottoNumber.LotteryRule.*;
import static lotto.common.Exceptions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LotteryNumberValidator {

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateEachNumber(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTERY_NUMBER_COUNT) {
            throw new IllegalArgumentException(WRONG_LOTTERY_NUMBER_SIZE.getMessage());
        }
    }

    private static void validateEachNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (addedDuplicated(number, uniqueNumbers)) {
                throw new IllegalArgumentException(DUPLICATED_LOTTERY_NUMBER.getMessage());
            }
            if (number < MIN_LOTTERY_NUMBER || number > MAX_LOTTERY_NUMBER) {
                throw new IllegalArgumentException(OUT_OF_LOTTERY_NUMBER_RANGE.getMessage());
            }
        }
    }

    private static boolean addedDuplicated(int number, Set<Integer> uniqueNumbers) {
        return !uniqueNumbers.add(number);
    }
}
