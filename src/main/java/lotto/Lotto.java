package lotto;

import java.util.HashSet;
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
        HashSet<Integer> uniqueNumbers = new HashSet<Integer>(numbers.size());
        for (int n : numbers) {
            if (uniqueNumbers.contains(n)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            }
            uniqueNumbers.add(n);
        }
    }
    
    public boolean hasNumber(int num) {
        return numbers.contains(num);
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
