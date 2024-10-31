package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (Integer winningNumber : numbers) {
            long count = numbers.stream().filter(number -> number.equals(winningNumber)).count();
            if (count != 1) {
                System.out.println("[ERROR] 로또 번호는 중복될 수 없습니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현

    public String toString() {
        return "[" +
                String.join(", ",
                        numbers.stream()
                                .map(String::valueOf)
                                .toArray(String[]::new)) +
                "]";
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
