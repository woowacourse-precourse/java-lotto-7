package lotto.domain;

import static lotto.exception.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.CustomIllegalArgumentException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersPoolGenerator {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int WINNING_NUMBERS_POOL_SIZE = 7;

    public List<Integer> createWinningNumbersPool() {
        List<Integer> numbersPool = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, WINNING_NUMBERS_POOL_SIZE);
        validateWinningNumbersPool(numbersPool);
        return numbersPool;
    }

    private void validateWinningNumbersPool(List<Integer> numbersPool) {
        validateSize(numbersPool);
        validateDuplicates(numbersPool);
        validateRange(numbersPool);
    }

    private void validateSize(List<Integer> numbersPool) {
        if (numbersPool.size() != WINNING_NUMBERS_POOL_SIZE) {
            throw CustomIllegalArgumentException.from(INVALID_POOL_SIZE);
        }
    }

    private void validateDuplicates(List<Integer> numbersPool) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbersPool);
        if (uniqueNumbers.size() != numbersPool.size()) {
            throw CustomIllegalArgumentException.from(DUPLICATE_NUMBER_IN_POOL);
        }
    }

    private void validateRange(List<Integer> numbersPool) {
        for (int number : numbersPool) {
            if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
                throw CustomIllegalArgumentException.from(NUMBER_OUT_OF_RANGE);
            }
        }
    }
}
