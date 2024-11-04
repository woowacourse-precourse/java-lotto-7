package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
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

    public String formatNumbers() {
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]\n";
    }

    public Integer countWinningNumbers(List<Integer> winningNumbers) {
        List<Integer> duplicate = new ArrayList<>(winningNumbers);
        duplicate.retainAll(numbers);

        return duplicate.size();
    }

    public boolean isBonusNumberMatch(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    // TODO: 추가 기능 구현
}
