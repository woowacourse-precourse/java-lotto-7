package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;

    }

    private void validateDuplicate(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있으면 안됩니다.");
        }
    }

    private void validateCount(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입니다.");
        }
    }

    public List<Integer> sortNumbers() {
        return this.numbers.stream().sorted(Integer::compareTo).toList();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int countMatchingNumbers(final Lotto otherLotto) {
        return Math.toIntExact(this.numbers.stream()
                .filter(otherLotto.getNumbers()::contains).count());
    }

    public boolean isContain(final int number) {
        return this.numbers.contains(number);
    }
}
