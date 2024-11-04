package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicates(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw  new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> numbersWithoutDuplicates = new HashSet<>(numbers);

        if (numbersWithoutDuplicates.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 없어야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            LottoNumberValidator.validateNumberRange(number);
        }
    }

    public String formatNumbers() {
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]\n";
    }

    public Integer countWinningNumbers(Lotto lotto) {
        List<Integer> duplicate = new ArrayList<>(lotto.numbers);
        duplicate.retainAll(numbers);

        return duplicate.size();
    }

    public boolean isBonusNumberMatch(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
