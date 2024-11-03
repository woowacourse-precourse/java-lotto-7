package lotto.winningNumber.domain;

import static lotto.global.util.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.global.util.ErrorMessage.INVALID_LOTTO_COUNT;
import static lotto.global.util.ErrorMessage.OUT_OF_RANGE_NUMBER;
import static lotto.global.util.LottoConst.MAX_LOTTO_NUMBER;
import static lotto.global.util.LottoConst.MIN_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.global.util.LottoConst;

public class WinningNumber {

    private List<Integer> numbers = new ArrayList<>();
    private int bonus;

    public WinningNumber(List<Integer> numbers, int bonus) {
        validate(numbers,bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public int calculateMatchCount(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(l -> this.numbers.contains(l))
                .count();
    }

    public boolean isBonusMatched(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(this.bonus);
    }

    private void validate(List<Integer> numbers, int bonus) {
        validateDuplicateNumbers(numbers);
        validateDuplicateBonus(numbers,bonus);
        validateCount(numbers);
        validateRange(numbers);
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if(uniqueNumber.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateDuplicateBonus(List<Integer> numbers, int bonus) {
        if(numbers.contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LottoConst.LOTTO_NUMBERS) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

}
