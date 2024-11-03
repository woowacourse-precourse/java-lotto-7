package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public List<String> getStringNumbers() {
        List<String> stringNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            stringNumbers.add(Integer.toString(number));
        }
        return stringNumbers;
    }
}
