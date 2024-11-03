package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.lotto.DuplicatedLottoNumberException;
import lotto.exception.lotto.InvalidRangeLottoNumberException;
import lotto.exception.lotto.InvalidSizeLottoNumberException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
        validate(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidSizeLottoNumberException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0 || number > 45) {
                throw new InvalidRangeLottoNumberException();
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if(nonDuplicateNumbers.size() != 6) {
            throw new DuplicatedLottoNumberException();
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
