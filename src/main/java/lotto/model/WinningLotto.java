package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto() {
        super(new ArrayList<>());
        this.bonusNumber = 0;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
