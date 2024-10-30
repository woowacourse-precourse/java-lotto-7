package lotto.service;

import lotto.domain.lotto.Lotto;

import java.util.List;

public class LottoService {

    private final Lotto lotto;

    public LottoService(Lotto lotto) {
        this.lotto = lotto;
    }

    public void addWinningNumbers(List<Integer> winningNumbers) {
        lotto.addNumbers(winningNumbers);
    }
}
