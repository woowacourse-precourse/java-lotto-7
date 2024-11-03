package lotto.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.ErrorMessages;

public class WinningLotto extends Lotto{
    private int bonusNumber;
    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateUniqueNumbers(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateUniqueNumbers(List<Integer> numbers, int bonusNumber){
        Set<Integer> numSet = new HashSet<>(numbers);

        if(!numSet.add(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessages.ERROR_DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return super.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
