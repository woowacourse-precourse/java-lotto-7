package lotto.vendingmachine;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        int tmp = 0;
        for (Integer number : numbers) {
            if (tmp == number) {
                throw new IllegalArgumentException("[ERROR] 로또 번호들은 서로 중복된 값을 가질 수 없습니다.");
            }
            tmp = number;
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        String string = "[";
        string += numbers.get(0);
        for (int i = 1; i < 6; i++) {
            string += ", " + numbers.get(i);
        }
        string += "]";

        return string;
    }
}
