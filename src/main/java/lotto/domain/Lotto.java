package lotto.domain;

import static lotto.constants.LottoRule.LOTTO_NUMBER_SIX;
import static lotto.constants.LottoRule.Lotto_Number_Max;
import static lotto.constants.LottoRule.Lotto_Number_Min;
import static lotto.constants.LottoRule.SAME_NUMBER_COUNT;
import static lotto.constants.LottoWinNumberException.NUMBER_ONLY_SIX;
import static lotto.constants.LottoWinNumberException.NUMBER_RANGE;
import static lotto.constants.LottoWinNumberException.SAME_NUMBER_NOT_ALLOWED;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkNumberCount(numbers);
        checkSameNumber(numbers);
        checkNumberRange(numbers);
        this.numbers = numbers;
    }

    private void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIX.getValue()) {
            throw new IllegalArgumentException(NUMBER_ONLY_SIX.getMessage());
        }
    }

    private void checkSameNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (Collections.frequency(numbers, number) > SAME_NUMBER_COUNT.getValue()) {
                throw new IllegalArgumentException(SAME_NUMBER_NOT_ALLOWED.getMessage());
            }
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Lotto_Number_Min.getValue() ||
                    number > Lotto_Number_Max.getValue()) {
                throw new IllegalArgumentException(NUMBER_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
