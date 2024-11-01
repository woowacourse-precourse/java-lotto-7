package lotto;

import java.util.List;

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

    public Integer howManyMatches(Lotto lotto) {
        Integer count = 0;
        for (Integer number : numbers) {
            if (lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }
}
