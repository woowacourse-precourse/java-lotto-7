package lotto.model.domain;

import lotto.PrizeRank;
import lotto.dto.LottoDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Constants.MAXIMUM_LOTTO_NUMBER;
import static lotto.Constants.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoInputErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public Lotto(LottoDto lottoDto) {
        this(lottoDto.numbers());
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public PrizeRank calculateResult(LottoWinningNumbers winningNumbers) {
        int matchCount = countMatches(winningNumbers.getWinningNumbers());
        boolean bonusMatched = containsNumber(winningNumbers.getBonusNumber());

        return PrizeRank.fromMatchCountAndBonus(matchCount, bonusMatched);
    }

    private int countMatches(Lotto winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    private boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < MINIMUM_LOTTO_NUMBER || num > MAXIMUM_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }
}
