package lotto.domain;

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
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또에 중복된 숫자가 존재합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    private boolean hasDuplicateNumber(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }



    // TODO: 추가 기능 구현
}
