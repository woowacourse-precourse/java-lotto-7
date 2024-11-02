package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sort(numbers);
        this.numbers = numbers;
    }

    public static Lotto generateRandomly() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto((numbers));
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateIsDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateIsDuplicated(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isInvalidRange)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidRange(int number) {
        return number < 1 || number > 45;
    }

    private void sort(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
