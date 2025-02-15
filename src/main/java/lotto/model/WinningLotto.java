package lotto.model;

import lotto.model.Lotto;
import lotto.constant.ExceptionMessage;
import lotto.constant.GameConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto extends Lotto{
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public void setBonusNumber(int bonusNumber) {
        validateWinningNumbers(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateWinningNumbers(int bonusNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>(super.getNumbers());
        uniqueNumbers.add(bonusNumber);
        if(uniqueNumbers.size() != GameConfig.WINNING_LOTTO_NUMBERS_COUNT){
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_WINNING_AND_BONUS_ERROR);
        }
        if(bonusNumber < GameConfig.MIN_RANGE_NUMBER || bonusNumber > GameConfig.MAX_RANGE_NUMBER){
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER_ERROR);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
