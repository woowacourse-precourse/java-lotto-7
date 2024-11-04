package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }
    public int getMatchCount(Lotto lotto) {
        int matchCount = 0;

        for (Integer number : numbers) {
            if (lotto.numbers.contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> numberSet = numbers.stream().collect(Collectors.toSet());
        if (numberSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}