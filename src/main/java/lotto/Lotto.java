package lotto;

import java.util.List;
import java.util.HashSet;

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
        HashSet<Integer> test = new HashSet<>(numbers);
        if(test.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 번호가 있으면 안됩니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getRank(List<Integer> comp, int bonus) {
        numbers.removeAll(comp);
        if(numbers.size() == 3)
            return 5;
        if(numbers.size() == 2)
            return 4;
        if(numbers.isEmpty())
            return 1;
        if(numbers.size() == 1) {
            if(numbers.contains(bonus))
                return 2;
            return 3;
        }
        return 0;
    }
}
