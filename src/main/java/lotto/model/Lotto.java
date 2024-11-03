package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        lottoNumbers.sort(Integer::compareTo);
        validate(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDistinct(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        int beforeDistinct = numbers.size();
        Set<Integer> distincted = new HashSet<>(numbers);
        int afterDistinct = distincted.size();
        if (beforeDistinct != afterDistinct) {
            throw new IllegalArgumentException("로또 번호는 중복이 될 수 없습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> (number < 1 || number > 45))) {
            throw new IllegalArgumentException("로또 번호의 범위는 1부터 45입니다.");
        }
    }
}
