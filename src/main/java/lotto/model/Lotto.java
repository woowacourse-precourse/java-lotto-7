package lotto.model;

import lotto.status.ErrorMessages;
import lotto.status.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto implements LottoConstants {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> duplicates = new HashSet<>(numbers);
        if (numbers.size() != duplicates.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBER.getMessage());
        }
    }
}
