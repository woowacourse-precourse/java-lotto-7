package lotto;

import java.util.List;

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
        if (checkDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 번호가 있습니다.");
        }
    }

    private boolean checkDuplicatedNumber(List<Integer> numbers) {
        return distinctCount(numbers) != numbers.size();
    }

    private long distinctCount(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    // TODO: 추가 기능 구현

    public List<Integer> getLotto() {
        return List.copyOf(numbers);
    }
}
