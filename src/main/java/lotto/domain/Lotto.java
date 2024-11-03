package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int START_VALUE = 1;
    private static final int END_VALUE = 45;
    private static final int COUNT = 6; // 이건 LottoService의 상수와 중복됨
    private static final String ERROR_NUMBER_OUT_OF_RANGE = String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            START_VALUE, END_VALUE);
    private static final String ERROR_NUMBER_COUNT = String.format("[ERROR] 로또 번호는 %d개여야 합니다.", COUNT);
    private static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        for (int number : numbers) {
            validateRange(number);
        }
        this.numbers = new ArrayList<>(numbers);
    }

    private void validateRange(int number) {
        if (number < START_VALUE || number > END_VALUE) {
            throw new IllegalArgumentException(ERROR_NUMBER_OUT_OF_RANGE);
        }
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(ERROR_NUMBER_COUNT);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
