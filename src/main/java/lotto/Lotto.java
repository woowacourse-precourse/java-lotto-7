package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lotto.constant.ErrorMessage.WINNING_NUMBER_COUNT_ERROR;
import static lotto.constant.ErrorMessage.WINNING_NUMBER_DUPLICATE_ERROR;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = new ArrayList<>();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBER_COUNT_ERROR.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            if (set.contains(numbers.get(i))) {
                throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE_ERROR.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void addNumbers(List<Integer> winningNumbers) {
        numbers.addAll(winningNumbers);
    }

    // TODO: 추가 기능 구현
}
