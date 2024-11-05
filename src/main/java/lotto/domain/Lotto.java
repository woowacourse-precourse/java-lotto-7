package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.MessageSource;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            //throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
            throw new IllegalArgumentException(MessageSource.getMessage("error.lotto.size"));

        }

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(MessageSource.getMessage("error.lotto.duplicate"));
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
