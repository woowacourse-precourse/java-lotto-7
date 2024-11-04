package lotto;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Integer getQuantity() {
        return lottos.size();
    }

    public Long getTotalPrizeMoney(WinningNumber winningNumber, BonusNumber bonusNumber) {
        Long totalPrize = 0L;
        for (Lotto lotto : lottos) {
            totalPrize += lotto.calculatePrizeMoney(winningNumber, bonusNumber);
        }

        return totalPrize;
    }
}
