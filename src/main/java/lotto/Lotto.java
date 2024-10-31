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
        isDuplicate(numbers);
    }

    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> s = new HashSet<>();
        for (Integer number : numbers) {
            if(!s.add(number)){
                throw new IllegalArgumentException(
                        String.format("[ERROR] 중복된 로또 번호가 있습니다: (%d).", number)
                );
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
