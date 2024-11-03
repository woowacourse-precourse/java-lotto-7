package lotto.item;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorName;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoValue() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(number>=1 && number<=45)) {
                throw new IllegalArgumentException(ErrorName.ErrorRange.getErrorMessage());
            }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorName.ErrorSixNumber.getErrorMessage());
        }

        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != 6) {
            throw new IllegalArgumentException(ErrorName.ErrorDuplication.getErrorMessage());
        }
        }
    }
}
