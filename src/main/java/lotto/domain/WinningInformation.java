package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningInformation {

    private static final LinkedHashMap<WinningPrize, Integer> prizeAndCount = new LinkedHashMap<>();

    private static final WinningInformation instance = new WinningInformation();

    private WinningInformation() {
    }

    static {
        prizeAndCount.put(WinningPrize.FAILURE, 0);
        prizeAndCount.put(WinningPrize.FIFTH, 0);
        prizeAndCount.put(WinningPrize.FOURTH, 0);
        prizeAndCount.put(WinningPrize.THIRD, 0);
        prizeAndCount.put(WinningPrize.SECOND, 0);
        prizeAndCount.put(WinningPrize.FIRST, 0);
    }

    public Map<WinningPrize, Integer> getPrizeAndCount() {
        return Collections.unmodifiableMap(prizeAndCount);
    }

    public static WinningInformation getInstance() {
        return instance;
    }

    public void addWinningCount(WinningPrize prize) {
        prizeAndCount.put(prize, prizeAndCount.get(prize) + 1);
    }

}
