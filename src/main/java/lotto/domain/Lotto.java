package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public final static Money LOTTO_PRICE = Money.from(1000L);

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

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public int countCommonElements(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }
}
