package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.enums.WinningType;

public class Lottos {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final Map<WinningType, Integer> winningResult = new HashMap<>();
    private final Integer bonusNumber;

    public Lottos(List<Lotto> lottos, final List<Integer> winningNumbers, final Integer bonusNumber) {
        initWinningResult();

        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void initWinningResult() {
        for (WinningType winningType : WinningType.values()) {
            winningResult.put(winningType, 0);
        }
    }

    public Map<WinningType, Integer> getWinningResult() {
        checkWinningResult();
        return winningResult;
    }

    public Long getTotalPrize() {
        Long totalPrize = 0L;

        for (WinningType winningType : winningResult.keySet()) {
            totalPrize += winningType.getPrize() * winningResult.get(winningType);
        }

        return totalPrize;
    }

    private void checkWinningResult() {
        for (Lotto lotto : lottos) {
            WinningType winningType = lotto.checkWinningNumbers(winningNumbers, bonusNumber);
            winningResult.put(winningType, winningResult.getOrDefault(winningType, 0) + 1);
        }
    }


}
