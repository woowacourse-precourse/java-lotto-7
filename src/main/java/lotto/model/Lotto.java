package lotto.model;

import lotto.enums.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INVALID_NUMBER_COUNT.getMessage());
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE_NUMBER.getMessage());
        }
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean matchingBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() { //객체 안에 든 값을 문자열로 변환하기 위해
        return numbers.toString();
    }

}
