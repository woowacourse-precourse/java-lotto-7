package lotto.domain;

import java.util.List;

public class Lotto {
    private final Numbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public Numbers getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
