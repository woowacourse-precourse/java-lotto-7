package lotto;

import java.util.List;

public class WinningLotto {
    private int bonusNumber;
    private Lotto lotto;

    public WinningLotto(int bonusNumber, List<Integer> numbers) {
        this.bonusNumber = bonusNumber;
        this.lotto = new Lotto(numbers);
    }

    public int getScore(Lotto lotto) {
        int normalCount = lotto.compare(this.lotto);
        int bonusCount = lotto.compare(this.bonusNumber);

        LottoState state = new LottoState(normalCount, bonusCount);
        return state.getScore();
    }
}
