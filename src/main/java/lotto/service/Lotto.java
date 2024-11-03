package lotto.service;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        notSameNumber(numbers);
        isRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void notSameNumber(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
    }

    private void isRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
