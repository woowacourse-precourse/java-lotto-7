package lotto.model.lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = List.copyOf(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
