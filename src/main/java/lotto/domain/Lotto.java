package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.ErrorMessages;
import lotto.common.LottoConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNoDuplicateNumbers(numbers);
        validateNumberRange(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public static Lotto from() {
        return new Lotto(generateUniqueRandomNumbers());
    }

    private static List<Integer> generateUniqueRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstants.LOTTO_MIN_NUMBER,
                LottoConstants.LOTTO_MAX_NUMBER,
                LottoConstants.LOTTO_SIZE
        );
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_SIZE_MESSAGE);
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        boolean hasDuplicates = new HashSet<>(numbers).size() != numbers.size();
        if (hasDuplicates) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_DUPLICATE_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean allInRange = numbers.stream().allMatch(this::isWithinAllowedRange);
        if (!allInRange) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_RANGE_MESSAGE);
        }
    }

    private boolean isWithinAllowedRange(int number) {
        return number >= LottoConstants.LOTTO_MIN_NUMBER && number <= LottoConstants.LOTTO_MAX_NUMBER;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    public boolean includesBonusNumber(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getNumber());
    }

    @Override
    public String toString() {
        return formatNumbersForDisplay();
    }

    private String formatNumbersForDisplay() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}


