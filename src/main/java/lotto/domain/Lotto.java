package lotto.domain;

import static lotto.global.error.LottoErrorMessages.*;
import static lotto.utils.Validator.BONUS_MATCH_THRESHOLD;
import static lotto.utils.Validator.MINIMAL_WINNING_NUMBER;
import static lotto.utils.Validator.TOTAL_LOTTO_NUMBERS;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.global.LottoRank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != TOTAL_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(INVALID_LOTTO_RANGE.getMessage());
        }
    }

    public LottoRank checkWinningStatus(List<Integer> winningNumbers, int bonusNumber) {

        int matchCount = getMatchCount(winningNumbers);

        if (matchCount < MINIMAL_WINNING_NUMBER) {
            return null;
        }

        if (matchCount != BONUS_MATCH_THRESHOLD) {
            return LottoRank.findByMatchCount(matchCount);
        }

        if (numbers.contains(bonusNumber)) {
            return LottoRank.SECOND;
        }

        return LottoRank.THIRD;
    }

    private int getMatchCount(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream().filter(numbers::contains).count();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
