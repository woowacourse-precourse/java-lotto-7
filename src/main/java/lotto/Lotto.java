package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import lotto.enums.ErrorType;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicateMyself(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean checkDuplicateWithBonusNumber(int bonusNum) {
        return numbers.contains(bonusNum);
    }

    public int findDuplicateNum(List<Integer> winningNumber) {

        List<Integer> matchNum = this.numbers.stream().filter(o -> winningNumber.stream()
                .anyMatch(Predicate.isEqual(o))).toList();

        return matchNum.size();
    }

    public void checkDuplicateMyself(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() < numbers.size()) {
            throw new IllegalArgumentException(ErrorType.INVALID_DUPLICATE_LOTTO_NUMBER.getErrorMessage());
        }
    }
}