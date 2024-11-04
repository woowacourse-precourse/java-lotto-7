package lotto.model;

import static lotto.utils.ExceptionConstants.DUPLICATED_NUM_INPUT;
import static lotto.utils.ExceptionConstants.NUMBER_OUT_OF_RANGE;
import static lotto.utils.ExceptionConstants.REQUIRED_SIX_NUMBERS;
import static lotto.utils.LottoConfig.LOTTO_MAX_NUM;
import static lotto.utils.LottoConfig.LOTTO_MIN_NUM;
import static lotto.utils.LottoConfig.LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(REQUIRED_SIX_NUMBERS.getExceptionMessage());
        }
        for(Integer number : numbers) {
            if (number < LOTTO_MIN_NUM.getValue() || number > LOTTO_MAX_NUM.getValue()) {
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getExceptionMessage());
            }
        }
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUM_INPUT.getExceptionMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
