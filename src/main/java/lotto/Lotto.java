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
        if (numbers == null) {
            throw new IllegalArgumentException("로또 번호는 NULL 일 수 없습니다.");
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        for (Integer number : numbers) {
            if (number == null) {
                throw new IllegalArgumentException("로또 번호는 null 을 포함할 수 없습니다.");
            }

            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자입니다. 잘못된 숫자 : " + number);
            }
        }

        HashSet<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현
}
