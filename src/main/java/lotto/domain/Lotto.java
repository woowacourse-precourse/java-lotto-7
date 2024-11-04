package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNoDuplicates(numbers);
        validateLottoNumberRange(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        ConcurrentHashMap<Integer, Boolean> uniqueValues = new ConcurrentHashMap<>();

        for (Integer number : numbers) {
            if (uniqueValues.putIfAbsent(number, true) != null) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
            }
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~ 45 사이여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
