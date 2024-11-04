package lotto.domain;

import java.util.List;

public class WinningLotto {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(int bonusNumber, List<Integer> lotto) {
        this.bonusNumber = bonusNumber;
        this.lotto = new Lotto(lotto);
    }
    
    public int countMatches(Lotto otherLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(i -> otherLotto.getNumbers().contains(i))
                .count();
    }

    public boolean isMatchedBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
