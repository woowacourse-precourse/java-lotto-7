package lotto.model;

import lotto.error.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final String DELIMITER = ", ";
    private static final int CORRECT_LOTTO_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != CORRECT_LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT.getMessage());
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        HashSet<Integer> hashSet = new HashSet<>(numbers);
        if (hashSet.size() != CORRECT_LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    @Override
    public String toString(){
        List<Integer> result = new ArrayList<>(numbers);
        Collections.sort(result);
        return String.join(DELIMITER, result.toString());
    }

    public int checkLotto(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean checkBonus(int bonus) {
        return numbers.contains(bonus);
    }
}
