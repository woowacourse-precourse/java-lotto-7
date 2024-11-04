package lotto.domain.WinningLotto;

import java.util.EnumMap;
import java.util.Map;

public class WinningLottoCounter {
    private final Map<WinningLotto, Integer> counts;

    public WinningLottoCounter() {
        counts = new EnumMap<WinningLotto, Integer>(WinningLotto.class);
        for (WinningLotto winningLotto : WinningLotto.values()) {
            counts.put(winningLotto, 0);
        }
    }

    public Map<WinningLotto, Integer> getCounts() {
        return counts;
    }

    public void incrementCount(WinningLotto winningLotto) {
        counts.put(winningLotto, counts.get(winningLotto) + 1);
    }
}
