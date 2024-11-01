package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalStateException("[ERROR] 넘어온 인수가 유효하지 않습니다.");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (int i : numbers) {
            if (!inRange(i)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 이상 45 이하의 정수여야 합니다.");
            }
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 각 번호는 서로 달라야 합니다.");
        }
    }

    private boolean inRange(int number) {
        return (number <= 45 && number >= 1);
    }
}
