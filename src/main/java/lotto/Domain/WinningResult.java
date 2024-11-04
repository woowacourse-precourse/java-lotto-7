package lotto.Domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private final Map<WinningRules, Integer> resultMap = new EnumMap<>(WinningRules.class);

    private WinningResult() {
        for (WinningRules rule : WinningRules.values()) {
            resultMap.put(rule, 0);
        }
    }

    public static WinningResult create() {
        return new WinningResult();
    }

    public void addResult(WinningRules rule) {
        resultMap.put(rule, resultMap.get(rule) + 1);
    }

    public int getCount(WinningRules rule) {
        return resultMap.get(rule);
    }

}
