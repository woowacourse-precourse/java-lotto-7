package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다." );
        }
    }


    // TODO: 추가 기능 구현
}
