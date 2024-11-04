package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.constant.LottoConst;
import lotto.constant.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplication(numbers);
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LottoConst.LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_SIZE_ERROR);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException(ExceptionMessage.LOTTO_DUPLICATION_ERROR);
            }
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        Collections.sort(copyNumbers);
        return copyNumbers.toString();
    }

    public void checkBonusNumberDuplication(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_DUPLICATION_ERROR);
        }
    }

    public int countContainNumber(Lotto winningNumbers) {
        return (int) winningNumbers.numbers.stream()
            .filter(winningNumber -> numbers.contains(winningNumber))
            .count();
    }

    public boolean needBonusNumber(int countNumber, int bonusNumber) {
        if (countNumber == LottoConst.BONUS_NUMBER_THRESHOLD) {
            return numbers.stream()
                .anyMatch(number -> number == bonusNumber);
        }
        return false;
    }
}
