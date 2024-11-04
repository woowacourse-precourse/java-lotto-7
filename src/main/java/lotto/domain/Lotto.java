package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.view.InputValidator;

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
        InputValidator.validateNumbersRange(numbers);
        InputValidator.validateNoDuplicates(numbers);
    }

    public Rank getRank(List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = countMatches(winningNumbers);
        boolean bonusMatch = numbers.contains(bonusNumber);
        return Rank.valueOf(matchCount, bonusMatch);
    }

    // TODO: 추가 기능 구현
    private int countMatches(List<Integer> winningNumbers) {
        int count = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }
}
