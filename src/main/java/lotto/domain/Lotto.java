package lotto.domain;

import lotto.util.NumberSorter;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (!numbers.stream().allMatch(this::validateNumberRange)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public boolean validateNumberRange(int number) {
        return 1 <= number && number <= 45;
    }

    @Override
    public String toString() {
        return NumberSorter.sort(numbers).toString();
    }
}
