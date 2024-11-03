package lotto.model;

import java.util.List;
import lotto.helper.valid.ValidLotto;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidLotto.checkCountNumber(numbers);
        ValidLotto.checkRangeNumber(numbers);
        ValidLotto.checkDuplicateNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public int countingMatchNumbers(Lotto winningLotto) {
        return (int) numbers.stream().filter(winningLotto::hasNumber).count();
    }
}
