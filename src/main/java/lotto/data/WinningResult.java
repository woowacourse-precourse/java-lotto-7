package lotto.data;

import java.util.EnumMap;
import java.util.Map;
import lotto.config.enumerate.WinningInfo;

public class WinningResult {

    private final Map<WinningInfo, Integer> winningCount = new EnumMap<>(WinningInfo.class);
    private double profitRate;

    public WinningResult() {
        for (WinningInfo info : WinningInfo.values()) {
            winningCount.put(info, 0);
        }
    }

    public Map<WinningInfo, Integer> getWinningCount() {
        return winningCount;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }
}
