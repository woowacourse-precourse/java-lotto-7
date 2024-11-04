package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
