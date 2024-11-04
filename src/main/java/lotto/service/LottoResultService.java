package lotto.service;

import lotto.model.Lotto;

import java.util.List;

public class LottoResultService {
    private List<Lotto> lottos;
    private Lotto winningLotto;
    private int bonusNumber;

    public LottoResultService(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(Lotto lottos, Lotto winningLotto) {
        int count = 0;
        for (int winningNumber : winningLotto.getNumbers()) {
            count += getMatchCount(lottos, winningNumber);
        }
        return count;
    }

    private static int getMatchCount(Lotto lottos, int winningNumber) {
        if (lottos.getNumbers().contains(winningNumber)) {
            return 1;
        }
        return 0;
    }

}
