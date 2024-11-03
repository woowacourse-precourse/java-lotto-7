package lotto;

import static lotto.model.constant.LottoRule.MAX_NUMBER;
import static lotto.model.constant.LottoRule.MIN_NUMBER;
import static lotto.model.constant.LottoRule.NUMBER_COUNT;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.constant.LottoRank;
import lotto.model.WinningNumbers;

public class Lotto {
    private static final String INVALID_COUNT_MESSAGE = "[ERROR] 로또 번호는 6개이어야 합니다.";
    private static final String OVER_RANGE_MESSAGE = "[ERROR] 로또 번호의 범위를 초과했습니다.";
    private static final String DUPLICATE_MESSAGE = "[ERROR] 중복된 로또 번호가 있습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT.getConstant()) {
            throw new IllegalArgumentException(INVALID_COUNT_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (distinctCount != NUMBER_COUNT.getConstant()) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < MIN_NUMBER.getConstant() || number > MAX_NUMBER.getConstant())) {
            throw new IllegalArgumentException(OVER_RANGE_MESSAGE);
        }
    }

    public LottoRank calculateRank(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        long winningCount = calculateWinning(winningNumbers);
        boolean isBonus = calculateBonus(bonusNumber);
        return matchRank(winningCount, isBonus);
    }

    private long calculateWinning(WinningNumbers winningNumbers) {
        return this.numbers.stream()
                .filter(winningNumbers::isWinningNumber)
                .count();
    }

    private boolean calculateBonus(BonusNumber bonusNumber) {
        return this.numbers.stream()
                .anyMatch(bonusNumber::isBonusNumber);
    }

    private LottoRank matchRank(long winningCount, boolean isBonus) {
        return LottoRank.getRank(winningCount, isBonus);
    }
}
