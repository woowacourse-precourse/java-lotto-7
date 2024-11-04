package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>();
        this.numbers.addAll(numbers);
        this.numbers.sort(Comparator.comparingInt(a -> a));
    }

    private void validate(List<Integer> numbers) {

        Set<Integer> set = new HashSet<>();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        for (int number : numbers) {

            if (set.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되었습니다.");
            }

            set.add(number);
        }
    }

    // TODO: 추가 기능 구현


    public List<Integer> getNumbers() {
        return numbers;
    }
}
