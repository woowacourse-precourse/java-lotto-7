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

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append('[');
        for (int i = 0; i < numbers.size(); i++) {
            str.append(numbers.get(i));
            if (i != numbers.size() - 1) {
                str.append(", ");
            }
        }
        str.append(']');
        return str.toString();
    }
}
