package lotto.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.ErrorMessages;
import lotto.utils.NumberConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        validateNumberCount(numbers);
        validateUniqueNumbers(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != NumberConstants.LOTTO_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers){
        Set<Integer> numSet = new HashSet<>(numbers);

        if(numSet.size() != numbers.size()){
            throw new IllegalArgumentException(ErrorMessages.ERROR_DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public int countMatchingNumbers(WinningLotto winningLotto) {
        int matchingCount = (int) this.numbers.stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
        return matchingCount;
    }

    public boolean isMatchBonus(WinningLotto winningLotto){
        if (this.numbers.contains(winningLotto.getBonusNumber())) {
            return true;
        }
        return false;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
