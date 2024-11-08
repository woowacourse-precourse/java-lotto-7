package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMS_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        hasDuplicateNum(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void hasDuplicateNum(List<Integer> numbers) {
        Set<Integer> nums = new HashSet<>(numbers);
        if (nums.size() != LOTTO_NUMS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복됩니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int number : numbers) {
            builder.append(number);
            builder.append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();
    }
}