package lotto.domain;

import java.util.*;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoSystemConstant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> initializationNumbers = new ArrayList<>(numbers);
        Collections.sort(initializationNumbers);
        validate(initializationNumbers);
        this.numbers = initializationNumbers;
    }

    private void validate(List<Integer> numbers) {
        validatePickCount(numbers);
        validateBoundary(numbers);
        validateNonDuplicate(numbers);
    }

    private void validatePickCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_PICK_COUNT) {
            throw new IllegalArgumentException(INVALID_PICK_COUNT);
        }
    }

    private void validateBoundary(List<Integer> numbers) {
        for (int number: numbers) {
            if(number < LOTTO_LOWER_BOUNDARY || number > LOTTO_UPPER_BOUNDARY) {
                throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_BOUND);
            }
        }
    }

    private void validateNonDuplicate(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if(numbers.get(i) == numbers.get(i - 1)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_INPUT);
            }
        }
    }

    public String getNumbers() {
        return numbers.toString();
    }

    public Rank checkRank(Lotto winningLotto, int bonusNumber) {
        int matchingNumbers = countMatchNumbers(winningLotto);
        boolean hasBonus = checkMatchNumber(bonusNumber);

        return Rank.valueOfLotto(matchingNumbers, hasBonus);
    }

    private int countMatchNumbers(Lotto lotto) {
        Set<Integer> checkingNumbers = new HashSet<>(numbers);
        checkingNumbers.retainAll(lotto.numbers);

        return checkingNumbers.size();
    }

    public boolean checkMatchNumber(int target) {
        for (int number: numbers) {
            if(number == target) {
                return true;
            }
        }

        return false;
    }
}
