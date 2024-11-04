package lotto.domain.entity;

import lotto.domain.rank.LottoRank;
import lotto.domain.exception.LottoException;
import lotto.domain.exception.LottoNumberExceptionMessage;
import lotto.util.ValidLottoNumber;

import java.util.Iterator;
import java.util.List;

public class Lotto implements Iterable<Integer> {

    private final List<Integer> numbers;
    private final LottoRank rank;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
        this.rank = LottoRank.NO_MATCH;
    }

    public Lotto(final List<Integer> numbers, final LottoRank rank) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
        this.rank = rank;
    }

    public LottoRank getRank() {
        return rank;
    }

    private void validate(List<Integer> numbers) {
        if (ValidLottoNumber.isNotBoundedNumbers(numbers)) {
            throw new LottoException(LottoNumberExceptionMessage.NUMBER_BOUNDED_EXCEPTION);
        }

        if (ValidLottoNumber.isNotSixNumbers(numbers)) {
            throw new LottoException(LottoNumberExceptionMessage.NUMBERS_LENGTH_EXCEPTION);
        }

        if (ValidLottoNumber.isDuplicate(numbers)) {
            throw new LottoException(LottoNumberExceptionMessage.DUPLICATE_EXCEPTION);
        }
    }

    public long countWinningNumbers(final Lotto winningLottos) {
        return this.numbers.stream().filter(winningLottos::containsNumber).count();
    }

    public boolean containsBonusNumber(final int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    private boolean containsNumber(final int number) {
        return this.numbers.contains(number);
    }

    public Lotto withRank(final LottoRank rank) {
        return new Lotto(this.numbers, rank);
    }

    public int size() {
        return this.numbers.size();
    }

    public String numbers() {
        return numbers.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.numbers.iterator();
    }
}
