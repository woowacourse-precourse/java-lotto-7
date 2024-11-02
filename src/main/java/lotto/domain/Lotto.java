package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getMatchNumberCount(List<Integer> numbers) {
        List<Integer> matchingNumbers = new ArrayList<>(numbers);
        matchingNumbers.retainAll(this.numbers);

        return matchingNumbers.size();
    }

    public Boolean hasNumber(Integer number) {
        return numbers.contains(number);
    }

    public static List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersRange(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개여야 합니다.", NUMBER_COUNT));
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d ~ %d 범위여야 합니다.", MIN_NUMBER, MAX_NUMBER));
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복되면 안됩니다.");
        }
    }
}
