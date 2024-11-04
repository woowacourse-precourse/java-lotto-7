package lotto.domain;

import java.util.Comparator;
import java.util.List;
import lotto.domain.exception.LottoException;
import lotto.domain.util.LottoNumberGenerator;
import lotto.global.common.Rank;

public class Lotto {

    public final static int TICKET_PRICE = 1_000;
    public final static int NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);

        this.numbers = numbers.stream()
                .sorted(Comparator.naturalOrder())
                .toList();
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw LottoException.invalidCount();
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw LottoException.duplicate();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LottoNumberGenerator.MIN_LOTTO_NUMBER || number > LottoNumberGenerator.MAX_LOTTO_NUMBER) {
                throw LottoException.outOfRange();
            }
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public Rank check(Lotto winningLotto, int bonus) {
        List<Integer> winningNumbers = winningLotto.getNumbers();

        return Rank.valueOf(countNumberMatches(numbers, winningNumbers), isBonusMatch(bonus));
    }

    private int countNumberMatches(List<Integer> numbers, List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isBonusMatch(int bonus) {
        return numbers.contains(bonus);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
