package lotto.domain;

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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCountWinningLotto(WinningLotto winningLotto) {
        return numbers.stream()
                .filter(number -> winningLotto.isContains(number))
                .collect(Collectors.toList()).size();
    }

    public boolean isMatchBonusNumber(BonusNumber bonusNumber) {
        int matchCount = numbers.stream()
                .filter(number -> bonusNumber.isMatch(number))
                .collect(Collectors.toList()).size();

        if (matchCount == 1) {
            return true;
        }
        return false;
    }
}
