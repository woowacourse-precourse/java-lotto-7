package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(ExceptionCode.NON_SIX_NUMBERS);
        }
        validateDuplicated(numbers);
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> validatedNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (!validatedNumbers.add(number)) {
                throw new LottoException(ExceptionCode.DUPICATED_ERROR);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
