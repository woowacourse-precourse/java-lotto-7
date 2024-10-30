package lotto.service;

import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;

import java.util.List;

public class LottoService {

    private final Lotto lotto;
    private final Bonus bonus;

    public LottoService(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public void addWinningNumbers(List<Integer> winningNumbers) {
        lotto.addNumbers(winningNumbers);
    }

    public void updateBonusNumber(int number) {
        bonus.updateNumber(number);
    }
}
