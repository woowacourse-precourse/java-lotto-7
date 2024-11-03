package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int NUMBER_SIZE = 6;
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복 될 수 없습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < NUMBER_MIN || number > NUMBER_MAX) {
                throw new IllegalArgumentException(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", NUMBER_MIN, NUMBER_MAX));
            }
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개여야 합니다.", NUMBER_SIZE));
        }
    }

    //  > 크기, 값의 범위, 중복 여부
    //- [ ] 번호를 정렬한다.
    //- [ ] 우승 로또와 맞는 개수를 전달한다.
    //- [ ] 보너스볼을 체크한다.
    //- [ ] 로또 번호를 전달한다.
}
