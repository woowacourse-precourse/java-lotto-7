package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public final static int MIN_NUMBER = 1;
    public final static int MAX_NUMBER = 45;
    public final static int LOTTO_SIZE = 6;
    public final static Money LOTTO_PRICE = Money.from(1000L);

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumbersInRange(numbers);
        validateDuplicatedNumbers(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하여야 합니다.");
            }
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        List<Integer> nonDuplicatedNumber = numbers.stream()
                .distinct()
                .toList();
        if (numbers.size() != nonDuplicatedNumber.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
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
