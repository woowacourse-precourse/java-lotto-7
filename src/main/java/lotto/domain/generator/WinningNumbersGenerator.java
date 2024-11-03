package lotto.domain.generator;

import static lotto.exception.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.result.WinningNumbers;
import lotto.exception.CustomIllegalArgumentException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersGenerator {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    public WinningNumbers generate() {
        List<Integer> lottoNumbers = createWinningNumbersPool();
        return new WinningNumbers(lottoNumbers);
    }

    private List<Integer> createWinningNumbersPool() {
        List<Integer> numbersPool = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_NUMBERS_COUNT);
        validateNumbersPool(numbersPool);
        return numbersPool;
    }

    private void validateNumbersPool(List<Integer> numbersPool) {
        validateNoDuplicates(numbersPool);
        validateWithinRange(numbersPool);
    }

    private void validateNoDuplicates(List<Integer> numbersPool) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbersPool);
        if (uniqueNumbers.size() != numbersPool.size()) {
            throw CustomIllegalArgumentException.from(DUPLICATE_NUMBER_IN_POOL);
        }
    }

    private void validateWithinRange(List<Integer> numbersPool) {
        for (int number : numbersPool) {
            if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
                throw CustomIllegalArgumentException.from(NUMBER_OUT_OF_RANGE);
            }
        }
    }
}
