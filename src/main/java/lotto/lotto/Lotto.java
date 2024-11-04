package lotto.lotto;

import java.util.List;
import lotto.lotto.providable.NumbersProvidable;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto create(NumbersProvidable numbersProvidable) {
        return new Lotto(numbersProvidable.provide());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        List<Integer> view = List.copyOf(numbers)
                .stream()
                .sorted()
                .toList();

        return view.toString();
    }

    public int calculateMatchingCount(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(this::hasNumber)
                .count();
    }

    public boolean hasNumber(int number) {
        return this.numbers.contains(number);
    }
}
