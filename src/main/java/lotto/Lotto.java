package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplication(List<Integer> numbers) {
        HashSet<Object> set = new HashSet<>(numbers);

        if(set.size() !=numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
