package lotto.model.domain;

import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstantValue;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        lottoCountShouldBeSixValidator(numbers);
        lottoNumberRangeValidator(numbers);
        lottoDuplicateValidator(numbers);
        this.numbers = numbers;
    }

    private void lottoCountShouldBeSixValidator(List<Integer> numbers) {
        if (numbers.size() != LottoConstantValue.LOTTO_NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_COUNT_SHOULD_BE_SIX_VALIDATOR.getMessage());
        }
    }

    private void lottoNumberRangeValidator(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConstantValue.LOTTO_MIN_NUM.getValue() || number > LottoConstantValue.LOTTO_MAX_NUM.getValue())
            {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_VALIDATOR.getMessage());
            }
        }
    }
    private void lottoDuplicateValidator(List<Integer> numbers) {
        Set<Integer> lottoNumbersSet = Set.copyOf(numbers);
        if (lottoNumbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE_VALIDATOR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}