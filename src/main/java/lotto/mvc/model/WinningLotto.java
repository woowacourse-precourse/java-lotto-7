package lotto.mvc.model;

import java.util.List;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public int getBonus() {
        return bonusNumber;
    }

    public void setBonus(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
