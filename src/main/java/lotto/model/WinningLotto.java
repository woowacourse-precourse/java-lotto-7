package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto extends Lotto{
    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
        this.winningNumbers = numbers;
    }

    public void settingBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
