package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lotto.constant.ExceptionConstant;
import lotto.constant.LottoConstant;

public class WinningNumbers {
    List<Integer> primaryNumbers;

    public WinningNumbers(List<Integer> primaryNumbers) {
        validate(primaryNumbers);
        this.primaryNumbers = primaryNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionConstant.NUMBER_COUNT);
        }
        boolean allInRange = numbers.stream()
                .allMatch(n -> n >= LottoConstant.LOTTO_NUMBER_MIN && n <= LottoConstant.LOTTO_NUMBER_MAX);
        if (!allInRange) {
            throw new IllegalArgumentException(ExceptionConstant.NUMBER_VALID_RANGE);
        }
        HashSet<Integer> checkNumbersCount = new HashSet<>(numbers);
        if (checkNumbersCount.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionConstant.DUPLICATE_NUMBER);
        }
    }

    public int calculateMatchingCount(Lotto lotto) {
        List<Integer> x = this.primaryNumbers;
        Set<Integer> primarySet = new HashSet<>(x);
        int a = (int) lotto.streamNumbers()
                .filter(primarySet::contains)
                .count();

        return a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(primaryNumbers, that.primaryNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(primaryNumbers);
    }
}