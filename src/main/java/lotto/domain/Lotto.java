package lotto.domain;

import java.util.*;

public class Lotto {

    private static final int LOTTO_COUNT = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    public int countSameNumbers(Lotto lotto) {
        return (int) java.util.stream.IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                .filter(i -> this.contains(i) && lotto.contains(i))
                .count();
    }

    public boolean contains(int otherNumber) {
        return numbers.stream().anyMatch(number -> number == otherNumber);
    }

    public boolean hasBonus(Bonus bonus) {
        return numbers.stream().anyMatch(bonus::isSame);
    }

    private void validate(List<Integer> numbers) {
        checkIfNumberSizeIsValid(numbers);
        checkIfNumberRangeIsValid(numbers);
        checkIfNumbersAreDuplicate(numbers);
    }

    private void checkIfNumberSizeIsValid(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkIfNumberRangeIsValid(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < START_NUMBER || number > END_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void checkIfNumbersAreDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 내에 중복된 숫자가 존재합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
