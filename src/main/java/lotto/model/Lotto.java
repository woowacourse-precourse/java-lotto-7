package lotto.model;

import static lotto.config.LottoInfo.LOTTO_NUMBER_SIZE;
import static lotto.config.LottoInfo.MAXIMUM_LOTTO_NUMBER;
import static lotto.config.LottoInfo.MINIMUM_LOTTO_NUMBER;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoException;
import lotto.exception.LottoException.DuplicateLottoNumberException;
import lotto.exception.LottoException.InvalidLottoCountSizeException;
import lotto.exception.LottoException.LottoNumberOutOfRangeException;
import lotto.util.generator.LottoNumberGenerator;
import lotto.vo.BonusNumber;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    public static Lotto createWinningLotto(final List<Integer> winningNumbers) {
        return new Lotto(winningNumbers);
    }

    public static Lotto createLottoNumber(final LottoNumberGenerator lottoNumberGenerator) {
        return new Lotto(createNumbersWithGenerator(lottoNumberGenerator));
    }

    private static List<Integer> createNumbersWithGenerator(final LottoNumberGenerator lottoNumberGenerator) {
        List<Integer> randomNumbers = lottoNumberGenerator.numberGenerator();
        return Collections.unmodifiableList(randomNumbers);
    }

    public int countMatchedNumbers(final Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contain)
                .count();
    }

    public boolean checkBonusNumberContain(final BonusNumber bonusNumber) {
        return this.contain(bonusNumber.number());
    }

    private boolean contain(final Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validateLottoNumber(final List<Integer> numbers) {
        hasOverThenMaxLottoNumberSize(numbers);
        hasDuplicateNumber(numbers);
        hasOverThenMaxNumber(numbers);
        hasLessThenMinNumber(numbers);
    }

    private void hasOverThenMaxLottoNumberSize(final List<Integer> numbers) {
        if (numbers.size() > LOTTO_NUMBER_SIZE.getValue()) {
            throw new InvalidLottoCountSizeException();
        }
    }

    private void hasDuplicateNumber(final List<Integer> numbers) {
        Set<Integer> numberGroup = new HashSet<>();
        for (Integer number : numbers) {
            if (!numberGroup.add(number)) {
                throw new DuplicateLottoNumberException();
            }
        }
    }

    private void hasOverThenMaxNumber(final List<Integer> numbers) {
        boolean hasOverMaxNumber = numbers.stream()
                .anyMatch(number -> (number > MAXIMUM_LOTTO_NUMBER.getValue()));

        if (hasOverMaxNumber) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    private void hasLessThenMinNumber(final List<Integer> numbers) {
        boolean hasLessMinNumber = numbers.stream()
                .anyMatch(number -> (number < MINIMUM_LOTTO_NUMBER.getValue()));

        if (hasLessMinNumber) {
            throw new LottoNumberOutOfRangeException();
        }
    }
}
