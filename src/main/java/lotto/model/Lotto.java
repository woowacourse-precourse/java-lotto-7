package lotto.model;

import java.util.List;

// 로또 한 세트(6개의 중복되지 않는 숫자)를 저장, 검사하는 클래스
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
        for (int number : numbers) {
            isInRange(number);
        }
        for (int i = 0; i < numbers.size() - 1; i++) {
            isDuplicate(numbers.get(i), numbers.subList(i + 1, numbers.size()));
        }
    }

    private void isInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void isDuplicate(int index, List<Integer> numbers) {
        if (numbers.contains(index)) {
            throw new IllegalArgumentException("[ERROR] 각 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.toString());
    }
}
