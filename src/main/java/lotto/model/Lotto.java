package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    @Override
    public String toString() {
        String numbers = joiningNumbers();
        return "[" + numbers + "]";
    }

    public List<Integer> getLotto() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private String joiningNumbers() {
        return this.numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

}
