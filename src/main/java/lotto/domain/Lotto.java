package lotto.domain;

import lotto.domain.LottoWinningTable;
import lotto.exceptions.LottoNotUniqueException;
import lotto.exceptions.LottoShortLengthException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.utils.LottoValidator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoShortLengthException();
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new LottoNotUniqueException();
        }
    }

    public LottoWinningTable getResult(final List<Integer> winningNumbers,final int bonusNumber) {

        int matchCount = calculateMatchCount(winningNumbers);

        if (matchCount < MINIMAL_WINNING_NUMBER) {
            return null;
        }

        if (matchCount != BONUS_MATCH_INTERSECTION_NUMBER) {
            return LottoWinningTable.findByMatchCount(matchCount);
        }

        if (numbers.contains(bonusNumber)) {
            return LottoWinningTable.SECOND;
        }

        return LottoWinningTable.THIRD;
    }

    private int calculateMatchCount(final List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
