package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        int matchingNumberCount = 0;
        for (Integer number : numbers) {
            if (winningLotto.getNumbers().contains(number)) {
                matchingNumberCount++;
            }
        }
        return matchingNumberCount;
    }
}
