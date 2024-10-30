package lotto.model;

import lotto.utils.Constants;

import java.util.*;

public class Lotto {
    private final TreeSet<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new TreeSet<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Constants.EXCEPTION_MESSAGE_PREFIX +
                    " 로또 번호는 6개여야 합니다.");
        }
    }
    
    public Set<Integer> getCommonNumbers(Set<Integer> basicNumber) {
        Set<Integer> commons = new TreeSet<>(numbers);
        commons.retainAll(basicNumber);
        return Collections.unmodifiableSet(commons);
    }
    
    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
    
    @Override
    public String toString() {
        return numbers.toString();
    }
    
}
