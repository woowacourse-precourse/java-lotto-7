package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<WinningStatus, Integer> result = new EnumMap<>(WinningStatus.class);

    public LottoResult() {
        for (WinningStatus status : WinningStatus.values()) {
            result.put(status, 0);
        }
    }

    public void add(WinningStatus winningStatus) {
        result.put(winningStatus, result.get(winningStatus) + 1);
    }

    public Map<WinningStatus, Integer> getResult() {
        result.remove(WinningStatus.NO_WIN);
        return result;
    }
}
