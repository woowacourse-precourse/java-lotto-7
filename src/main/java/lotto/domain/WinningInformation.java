package lotto.domain;

import java.util.LinkedHashMap;

public class WinningInformation {

    private static final LinkedHashMap<WinningPrize, Integer> priceAndCount = new LinkedHashMap<>();

    private static final WinningInformation instance = new WinningInformation();

    private WinningInformation() {
    }

    static {
        priceAndCount.put(WinningPrize.FAILURE, 0);
        priceAndCount.put(WinningPrize.FIFTH, 0);
        priceAndCount.put(WinningPrize.FOURTH, 0);
        priceAndCount.put(WinningPrize.THIRD, 0);
        priceAndCount.put(WinningPrize.SECOND, 0);
        priceAndCount.put(WinningPrize.FIRST, 0);
    }

    public static WinningInformation getInstance() {
        return instance;
    }

    public void addWinningCount(WinningPrize prize) {
        priceAndCount.put(prize, priceAndCount.get(prize) + 1);
    }

}
