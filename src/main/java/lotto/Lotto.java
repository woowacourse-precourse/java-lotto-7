package lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        List<Integer> otherNumbers = otherLotto.getNumbers();
        return (int) numbers.stream()
                            .filter(otherNumbers::contains)
                            .count();
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
