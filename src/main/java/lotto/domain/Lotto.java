package lotto.domain;

import static lotto.util.LottoValidator.validateLottoNumbers;

import java.util.Collections;
import java.util.List;
import lotto.util.Ranking;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public Ranking calculateRank(List<Integer> winningNumbers, Integer bonusNumber) {
        int matchingCount = countMatchingNumbers(winningNumbers);
        boolean hasBonusNumber = numbers.contains(bonusNumber);

        return Ranking.getRanking(matchingCount, hasBonusNumber);
    }

    private int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
