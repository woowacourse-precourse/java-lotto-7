package lotto;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoWinningResult {
    private final Map<LottoWinningStandard, Integer> winningInfo = new LinkedHashMap<>();

    public LottoWinningResult() {
        for(LottoWinningStandard standard : LottoWinningStandard.values()) {
            this.winningInfo.put(standard, 0);
        }
    }

    public void setWinningInfo(LottoWinningStandard name, int count) {
        this.winningInfo.put(name, count);
    }

    public Map<LottoWinningStandard, Integer> getWinningStandard() {
        return winningInfo;
    }

    public int getWinningInfoValueByKey(LottoWinningStandard key) {
        return this.winningInfo.get(key);
    }
}
