package lotto.model;

import lotto.util.LottoOperator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos() {
        this.lottoList = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    public void getMatchCount(Lotto winningNumber, int bonusNumber) {
        lottoList.forEach(lotto -> {
            boolean isMatchBonusNumber = lotto.getNumbers().stream()
                    .anyMatch(number -> number == bonusNumber);

            long matchCount = winningNumber.getNumbers().stream()
                    .filter(lotto.getNumbers()::contains)
                    .count();
            LottoOperator.addCount(isMatchBonusNumber, matchCount);
        });
    }
}
