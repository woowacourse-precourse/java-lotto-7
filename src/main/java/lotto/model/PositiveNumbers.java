package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PositiveNumbers {

    private final List<PositiveNumber> numbers = new ArrayList<>();

    public PositiveNumbers(List<Long> numbers) {
        this.numbers.addAll(numbers.stream().map(PositiveNumber::new).toList());
    }

    public PositiveNumbers(String[] numbers) {
        this(Arrays.stream(numbers).map(Long::parseLong).toList());
    }

    public List<PositiveNumber> get() {
        return Collections.unmodifiableList(numbers);
    }

    public int size() {
        return numbers.size();
    }
}
