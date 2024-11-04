package lotto.model;
import lotto.exceptions.LottoDuplicateNumberException;
import lotto.exceptions.LottoInvalidCountException;
import lotto.exceptions.LottoNumberRangeException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoInvalidCountException();
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new LottoDuplicateNumberException();
        }

        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new LottoNumberRangeException();
            }
        }
    }
}