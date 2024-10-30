package lotto.service;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;

import java.util.List;

public class LottoService {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public LottoService(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public void addWinningNumbers(List<Integer> winningNumbers) {
        lotto.addNumbers(winningNumbers);
    }

    public void updateBonusNumber(int number) {

    }
}
