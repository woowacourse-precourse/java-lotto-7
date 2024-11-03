package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {

    public final Map<WinningPrice, Integer> result = new LinkedHashMap<>();

    private LottoResult() {
        for (WinningPrice price : WinningPrice.values()) {
            result.put(price, 0);
        }
    }

    public static LottoResult create() {
        return new LottoResult();
    }

    public int countWinningPrice(WinningPrice winningPrice) {
        result.put(winningPrice, result.get(winningPrice) + 1);
        return result.get(winningPrice);
    }

    public Map<WinningPrice, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

}
