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
        Set<Integer> uniqueNumbers = new HashSet<>();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }

            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력하세요.");
            }
        }
    }

    public List<Integer> getLotto() {
        return numbers.stream()
                .sorted()
                .toList();
    }

}
