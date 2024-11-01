package lotto.domain;

import static lotto.constant.LottoConstants.LOTTO_RANGE_MAX;
import static lotto.constant.LottoConstants.LOTTO_RANGE_MIN;
import static lotto.constant.LottoConstants.LOTTO_SIZE;
import static lotto.error.ErrorType.DUPLICATION_NUM;
import static lotto.error.ErrorType.INSUFFICIENT_OR_EXCESSIVE_NUMBERS;
import static lotto.error.ErrorType.INVALID_BONUS_NUM;
import static lotto.error.ErrorType.OUT_OF_RANGE_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.error.exception.InvalidBonusNumberException;
import lotto.error.exception.InvalidLottoNumberException;
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
        numbers.forEach(this::validateNumberRange);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void validateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new InvalidBonusNumberException(INVALID_BONUS_NUM);
        }
        validateNumberRange(bonusNumber);
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
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidLottoNumberException(INSUFFICIENT_OR_EXCESSIVE_NUMBERS);
        }
    }

    private void validateNoDuplicate(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new InvalidLottoNumberException(DUPLICATION_NUM);
        }
    }

    private void validateNumberRange(final int number) {
        if (number < LOTTO_RANGE_MIN || number > LOTTO_RANGE_MAX) {
            throw new InvalidLottoNumberException(OUT_OF_RANGE_NUMBER);
        }
    }
}
