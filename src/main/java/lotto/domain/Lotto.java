package lotto.domain;

import static lotto.ui.ErrorMessage.ERROR_CONSTRAINTS_OF_LOTTO_LENGTH;
import static lotto.ui.ErrorMessage.ERROR_OVERLAP_WINNINGS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_CONSTRAINTS_OF_LOTTO_LENGTH);
        }
    }

    private void validateUnique(List<Integer> numbers){
        Set<Integer> nums = new HashSet<>(numbers);

        if(nums.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_OVERLAP_WINNINGS);
        }
    }

    public String toString() {
        List<Integer> numbers = new ArrayList<>(this.numbers);
        numbers.sort(Integer::compareTo);

        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
