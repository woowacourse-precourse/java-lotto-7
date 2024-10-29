package lotto.domain;

import java.util.Collections;
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
    }

    // TODO: 추가 기능 구현
    public int getRank(Set<Integer> winningNumbers, int bonusNumber) {
        List<Integer> list = numbers.stream()
                .filter(number -> !winningNumbers.contains(number))
                .toList();
        if (list.size() == 0) {
            return 1;
        }
        if (list.size() == 1) {
            if (list.get(0) == bonusNumber) {
                return 2;
            }
            return 3;
        }
        if (list.size() == 2) {
            return 4;
        }
        if (list.size() == 3) {
            return 5;
        }
        return 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
