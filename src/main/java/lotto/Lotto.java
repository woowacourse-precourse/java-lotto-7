package lotto;

import java.util.ArrayList;
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

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        List<Integer> numbers = new ArrayList<>(this.numbers);
        numbers.sort((n1, n2) -> n1.compareTo(n2));

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int number : numbers) {
            sb.append(number);
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");

        return sb.toString();
    }
}
