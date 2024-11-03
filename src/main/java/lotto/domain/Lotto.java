package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1에서 45 사이여야 합니다.");
        }
        if (hasDuplicatesEachNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private boolean isValidRange(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> num >= 1 && num <= 45);
    }

    private boolean hasDuplicatesEachNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public boolean hasDuplicatedBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public Integer matching(List<Integer> userLotto) {
        Set<Integer> numbers = new HashSet<>(this.numbers);
        Set<Integer> userNumbers = new HashSet<>(userLotto);
        numbers.retainAll(userNumbers);
        int matchCount = numbers.size();
        return matchCount;
    }
}
