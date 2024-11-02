package lotto.validation;

import java.util.HashSet;
import java.util.List;
import lotto.exception.LottoException;

public class LottoValidation {

    private static final int LOTTO_SIZE = 6;
    private static final int NUM_MIN = 1;
    private static final int NUM_MAX = 45;
    private static final int COUNT_ONE = 1;

    public static void lottoValidation(List<Integer> numbers) {
        for (int num : numbers) {
            isInRange(num);
        }
        isSizeSix(numbers);
        isDuplicate(numbers);
        isAscending(numbers);
    }

    public static void isInRange(int num) {
        if (num < NUM_MIN || num > NUM_MAX) {
            LottoException.exceptionLottoRange();
        }
    }

    public static void isSizeSix(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            LottoException.exceptionLottoSize();
        }
    }

    public static void isDuplicate(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>();
        for (int num : numbers) {
            numberSet.add(num);
        }
        if (numberSet.size() != LOTTO_SIZE) {
            LottoException.exceptionLottoDuplicate();
        }
    }

    public static void isAscending(List<Integer> numbers) {
        int index = COUNT_ONE;
        for (; index < LOTTO_SIZE; index++) {
            compareNum(numbers, index);
        }
    }

    public static void compareNum(List<Integer> numbers, int index) {
        if (numbers.get(index - COUNT_ONE) > numbers.get(index)) {
            LottoException.exceptionLottoAscending();
        }
    }

}