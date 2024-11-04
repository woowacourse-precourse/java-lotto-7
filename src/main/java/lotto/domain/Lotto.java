package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size())
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 숫자로 이루어져야 합니다.");

        for(int number : numbers) {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 범위여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
