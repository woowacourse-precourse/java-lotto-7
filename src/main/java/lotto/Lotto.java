package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        arrangeInAscendingOrder(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.getLast() > 45 || numbers.getFirst() < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하입니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void arrangeInAscendingOrder(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
