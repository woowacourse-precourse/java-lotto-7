package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUnique(List<Integer> numbers){
        Set<Integer> nums = new HashSet<>(numbers);

        if(nums.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 존재합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public String toString() {
        return numbers.toString();
    }
}
