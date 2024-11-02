package lotto.domain.lottos;

import static lotto.domain.InputErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.domain.InputErrorMessage.LOTTO_RANGE;
import static lotto.domain.InputErrorMessage.SIX_LOTTO_INPUT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final static int MIN = 1;
    private final static int MAX = 45;
    private final static int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoRange(numbers);
        validateLottoDuplicate(numbers);

        this.numbers = numbers;
    }

    public boolean isContainNumber(int number) {
        return numbers.contains(number);
    }

    public int getMatchedCount(final Lotto randomLotto) {
        int result = 0;

        for (Integer userLottoNumber : numbers) {
            if (randomLotto.numbers.contains(userLottoNumber)) {
                result += 1;
            }
        }
        return result;
    }


    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(SIX_LOTTO_INPUT.getMessage());
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN || number > MAX) {
                throw new IllegalArgumentException(LOTTO_RANGE.getMessage());
            }
        }
    }

    private void validateLottoDuplicate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }


    @Override
    public String toString() {
        List<Integer> printout = new ArrayList<>(numbers);
        Collections.sort(printout);
        return printout.toString();
    }

}
