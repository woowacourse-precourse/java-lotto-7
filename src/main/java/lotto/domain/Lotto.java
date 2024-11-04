package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_MAXIMUM_BOUND;
import static lotto.constant.LottoConstant.LOTTO_MINIMUM_BOUND;
import static lotto.constant.LottoConstant.LOTTO_SIZE;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.InputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortLottoNumbers(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicatedNumber(numbers);
        validateRangeOfNumbers(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw InputException.from(ErrorMessage.LOTTO_SIZE_IS_NOT_VALID);
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (findLottoSizeWithoutDuplicated(numbers) != LOTTO_SIZE) {
            throw InputException.from(ErrorMessage.LOTTO_NUMBER_HAS_DUPLICATED_NUMBER);
        }
    }

    private int findLottoSizeWithoutDuplicated(List<Integer> numbers) {
        return (int) numbers.stream()
                .distinct()
                .count();
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        if (isNotInValidRange(numbers)) {
            throw InputException.from(ErrorMessage.LOTTO_NUMBER_HAS_OUT_OF_BOUND_NUMBER);
        }
    }

    private boolean isNotInValidRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number ->
                        number < LOTTO_MINIMUM_BOUND || number > LOTTO_MAXIMUM_BOUND
                );
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
