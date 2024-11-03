package lotto.model;

import lotto.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        //vliad
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public void validate(List<Integer> numbers, int bonusNumber) {
        Set<Integer> setForValid = new HashSet<>(numbers);
        setForValid.add(bonusNumber);
        if(setForValid.size() != 7){
            throw new IllegalArgumentException();
        }
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
