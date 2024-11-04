package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        this.numbers = validateAndSort(numbers);
    }
    
    private List<Integer> validateAndSort(final List<Integer> numbers) {
    	validateCount(numbers);
        validateUnique(numbers);
        return getSortedNumbers(numbers);
    }

    private void validateCount(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_COUNT);
        }
    }
    
    private void validateUnique(final List<Integer> numbers) {
    	Set<Integer> set = new HashSet<>();
		
		for (int number : numbers) {
			if (set.contains(number)) {
				throw new IllegalArgumentException(DUPLICATED_NUMBERS);
			}
			set.add(number);
		}
    }
    
    private List<Integer> getSortedNumbers(final List<Integer> numbers) {
    	List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
    
    public List<Integer> getNumbers() {
    	return numbers;
    }
    
    @Override
    public String toString() {
    	return numbers.toString();
    }
}
