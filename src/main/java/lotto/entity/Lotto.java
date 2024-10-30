package lotto.entity;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
        if (numbers.stream().anyMatch(number -> !(1 <= number && number <= 45))) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자여야 합니다.");
        }
    }


}
