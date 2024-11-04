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
}
