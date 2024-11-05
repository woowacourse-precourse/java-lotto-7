package lotto.domain;

import static lotto.constant.LottoInfo.END_NUMBER;
import static lotto.constant.LottoInfo.PICK_COUNT;
import static lotto.constant.LottoInfo.START_NUMBER;
import static lotto.constant.ErrorMessage.NUMBER_COUNT_NOT_VALID;
import static lotto.constant.ErrorMessage.NUMBER_DUPLICATED;
import static lotto.constant.ErrorMessage.NUMBER_OUT_OF_RANGE;
import static lotto.domain.WinningInfo.SECOND;
import static lotto.domain.WinningInfo.THIRD;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumberCount(numbers);
        for (int number : numbers) {
            checkNumberRange(number);
        }
        checkNumberDuplicated(numbers);
    }

    // TODO: 추가 기능 구현
    public void showNumbers() {
        System.out.println(numbers);
    }

    private void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != PICK_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_NOT_VALID);
        }
    }

    static void checkNumberRange(int number) {
        if (number < START_NUMBER || number > END_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE);
        }
    }

    static void checkNumberDuplicated(List<Integer> validRangeNumbers) {
        Set<Integer> distinctNumbers = new HashSet<>(validRangeNumbers);
        if (distinctNumbers.size() != validRangeNumbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATED);
        }
    }

    public int findPlace(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<Integer> winningNumber = winningNumbers.getNumbersList();
        int matchingNumberCount = findMatchingNumberCount(winningNumber);
        if (matchingNumberCount != SECOND.getMatchingNumberCount()) {
            return findPlaceExceptSecondAndThird(matchingNumberCount);
        }
        return findPlaceSecondOrThird(bonusNumber);
    }

    private int findMatchingNumberCount(List<Integer> winningNumbers) {
        int matchingNumberCount = 0;
        for (int number : winningNumbers) {
            if (numbers.contains(number)) {
                matchingNumberCount++;
            }
        }
        return matchingNumberCount;
    }

    private int findPlaceExceptSecondAndThird(int matchingNumberCount) {
        for (WinningInfo info : WinningInfo.values()) {
            if (matchingNumberCount == info.getMatchingNumberCount()) {
                return info.getPlace();
            }
        }
        return 0;
    }

    private int findPlaceSecondOrThird(BonusNumber bonusNumber) {
        if (numbers.contains(bonusNumber.getNumber())) {
            return SECOND.getPlace();
        }
        return THIRD.getPlace();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
