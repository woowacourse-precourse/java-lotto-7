package lotto.model;

import lotto.utils.Constants;

import java.util.*;

/** 로또 티켓으로 중복되지 않은 여섯개의 숫자로 이루어진다. */
public class Lotto {
    
    private static final String EXCEPTION_MESSAGE_DUPLICATE =
            Constants.EXCEPTION_MESSAGE_PREFIX + " 로또 번호는 중복되지 않아야 합니다.";
    
    private final TreeSet<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        this.numbers = new TreeSet<>(numbers);
    }
    
    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Constants.EXCEPTION_MESSAGE_PREFIX +
                    " 로또 번호는 6개여야 합니다.");
        }
    }
    
    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numbersRemovedDuplicate = new HashSet<>(numbers);
        if (numbersRemovedDuplicate.size() != numbers.size()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_DUPLICATE);
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
