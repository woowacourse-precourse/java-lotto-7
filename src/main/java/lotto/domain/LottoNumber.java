package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public static List<Integer> pickRandomNumbers(int counter) {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, counter);
    }

    public static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_INVALID);
        }
    }

    public static void validateDuplicated(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER);
        }
    }

    public static void validateLottoRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    public static void validateLottoDuplicated(List<Integer> numbers) {
        List<Integer> temp = new ArrayList<>();
        for (int number : numbers) {
            validateDuplicated(temp, number);
            temp.add(number);
        }
    }
}