package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String ERROR_NUMBER_OUT_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_NUMBER_DUPLICATE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private static final String ERROR_NUMBER_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateNumberRange(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int countMatchNumber(Lotto winningLotto) {
        int matchCount = 0;

        for (Integer number : numbers) {
            if (winningLotto.containsNumber(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException(ERROR_NUMBER_OUT_OF_RANGE);
            }
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);

        if (numberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_NUMBER_DUPLICATE);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_NUMBER_SIZE);
        }
    }
}
