package lotto.model;

import java.util.HashSet;
import java.util.List;

public class WinningNumber {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String INVALID_NUMBER_COUNT_ERROR_MESSAGE = "로또 번호는 " + LOTTO_NUMBER_COUNT + "개 입니다.";
    private static final String INVALID_NUMBER_RANGE_ERROR_MESSAGE =
            "로또 숫자는 " + MIN_LOTTO_NUMBER + "이상 " + MAX_LOTTO_NUMBER + " 이하입니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복된 번호가 있습니다.";
    List<Integer> numberList;

    public WinningNumber(List<Integer> numberList) {
        validate(numberList);
        this.numberList = numberList;
    }

    private void validate(List<Integer> numberList) {
        validateNumberCount(numberList);
        validateNumberRange(numberList);
        validateDuplicateNumber(numberList);
    }

    private void validateNumberCount(List<Integer> numberList) {
        if (numberList.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numberList) {
        for (int number : numberList) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numberList) {
        HashSet<Integer> hashSet = new HashSet<>(numberList);
        if (hashSet.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }

    }

    public int checkSameCount(List<Integer> numbers) {
        numbers.retainAll(numberList);
        return numbers.size();
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
