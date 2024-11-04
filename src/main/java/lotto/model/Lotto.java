package lotto.model;

import lotto.LottoConfig;
import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int matchCount(Lotto other) {
        return (int) numbers.stream()
                .filter(other::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}