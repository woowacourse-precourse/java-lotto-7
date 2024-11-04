package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }


    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> unique = new HashSet<>();
        for (Integer number : numbers) {
            if(!unique.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
            }
        }

    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
