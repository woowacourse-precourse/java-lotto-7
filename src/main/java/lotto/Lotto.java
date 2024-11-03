package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.InvalidLottoNumbersDuplicateException;
import lotto.exception.InvalidLottoNumbersSizeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidLottoNumbersSizeException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);

        if (numbersSet.size() != numbers.size()) {
            throw new InvalidLottoNumbersDuplicateException();
        }
    }
}
