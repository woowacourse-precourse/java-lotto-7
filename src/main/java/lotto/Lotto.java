package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 하며, 중복이 없어야 합니다.");
        }

        boolean isWrongRange = numbers.stream().anyMatch(number -> number < 1 || number > 45);
        if(isWrongRange) {
            throw new IllegalArgumentException("로또 번호는 1에서 45사이어야 합니다.");
        }
    }

    // TODO: 추가 기능 구현


    public List<Integer> getNumbers() {
        return numbers;
    }
}
