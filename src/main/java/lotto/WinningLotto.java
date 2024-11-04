package lotto;

import java.util.List;

public class WinningLotto {
    private int bonusNumber;
    private Lotto lotto;

    public WinningLotto(int bonusNumber, List<Integer> numbers) {
        this.bonusNumber = bonusNumber;
        this.lotto = new Lotto(numbers);
    }
}
