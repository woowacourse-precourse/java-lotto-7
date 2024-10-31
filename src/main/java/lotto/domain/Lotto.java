package lotto.domain;

import static lotto.exception.ErrorType.DUPLICATION_NUM;
import static lotto.exception.ErrorType.INSUFFICIENT_OR_EXCESSIVE_NUMBERS;
import static lotto.exception.ErrorType.INVALID_BONUS_NUM;
import static lotto.exception.ErrorType.OUT_OF_RANGE_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidLottoNumberException;
import lotto.generator.LottoGenerator;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createRandomNumberLotto(LottoGenerator lottoGenerator) {
        List<Integer> generatedSortedNumbers = lottoGenerator.generate().stream()
                .sorted().toList();
        return new Lotto(generatedSortedNumbers);
    }

    public static Lotto createFixedNumberLotto(List<Integer> numbers) {
        List<Integer> sortedNumber = numbers.stream().sorted().toList();
        return new Lotto(sortedNumber);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNoDuplicate(numbers);
        validateNumberRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void validateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new InvalidBonusNumberException(INVALID_BONUS_NUM);
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new InvalidLottoNumberException(OUT_OF_RANGE_NUMBER);
        }
    }

    public int calculateMatchCount(Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isBonusMatched(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidLottoNumberException(INSUFFICIENT_OR_EXCESSIVE_NUMBERS);
        }
    }

    private void validateNoDuplicate(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new InvalidLottoNumberException(DUPLICATION_NUM);
        }
    }

    private void validateNumberRange(final List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 1 || number > 45) {
                throw new InvalidLottoNumberException(OUT_OF_RANGE_NUMBER);
            }
        });
    }
}
