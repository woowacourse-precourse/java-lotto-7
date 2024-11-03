package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    private static final String WRONG_SIZE = "로또 번호는 6개여야 합니다.";
    private static final String WRONG_RANGE = "숫자 범위가 벗어났습니다.";
    private static final String DUPLICATE_NUMBER = "중복되는 숫자가 있습니다.";

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        checkRange(numbers);
        checkDuplicate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbers();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WRONG_SIZE);
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(number > 0 && number <= 45)) {
                throw new IllegalArgumentException(WRONG_RANGE);
            }
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }

    private void sortNumbers() {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
