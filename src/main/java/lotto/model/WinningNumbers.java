package lotto.model;

import lotto.exception.ExceptionMessage;
import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final Number bonusNumber;

    public WinningNumbers(Lotto winningLotto,Number bonus){
        if(winningLotto.contains(bonus)) {
            throw new InputException(ExceptionMessage.DUPLICATED_NUMBER_ERROR);
        }
        this.winningLotto = winningLotto;
        this.bonusNumber = bonus;
    }

    public Reward getReward(Lotto lotto){
        List<Number> numbers = lotto.getNumbers();
        boolean bonus = numbers.contains(this.bonusNumber);
        int count = (int) winningLotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();

        return Reward.getRank(count,bonus);
    }

}
