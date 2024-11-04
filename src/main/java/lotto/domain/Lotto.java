package lotto.domain;

import java.util.List;
import lotto.utils.ValidatorFactory;
import lotto.validation.Validator;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        Validator<List<Integer>> uniqueNumberValidator = ValidatorFactory.createUniqueNumberValidator();
        Validator<Integer> rangeValidator = ValidatorFactory.createNumberRangeValidator(MIN_NUMBER, MAX_NUMBER);
        Validator<List<Integer>> countValidator = ValidatorFactory.createNumberCountValidator(LOTTO_NUMBER_COUNT);

        uniqueNumberValidator.validate(numbers);
        countValidator.validate(numbers);
        numbers.forEach(rangeValidator::validate);
    }

    public List<Integer> getNumbers() {
        return numbers.stream().toList();
    }

    public Rank match(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int matchCount = (int) numbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
        boolean matchBonus = numbers.contains(bonusNumber.getNumber());

        return Rank.findRank(matchCount, matchBonus);
    }
}
