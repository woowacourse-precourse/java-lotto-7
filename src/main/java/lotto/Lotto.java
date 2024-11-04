package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int NUMBERS_COUNT = 6;
    public static final int PRICE_PER_TICKET = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        // 로또 번호는 6개여야 한다
        if (numbers.size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        // 중복된 번호 체크
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
        }

        // 번호 범위 체크
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 범위 내의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
