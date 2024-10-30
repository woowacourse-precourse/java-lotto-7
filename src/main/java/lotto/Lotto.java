package lotto;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            sb.append(numbers.get(i).toString());
            sb.append(", ");
        }
        sb.append(numbers.getLast());
        sb.append("]");

        return sb.toString();
    }
}
