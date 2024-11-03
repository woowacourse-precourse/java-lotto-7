package lotto.dto;

import static lotto.eunm.WinningResult.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.eunm.WinningResult;

public class WinningDto {

    private final Map<WinningResult, Integer> winningCount;
    private double price;

    private WinningDto(Map<WinningResult, Integer> winningCount, double price) {
        this.winningCount = winningCount;
        this.price = price;
    }

    public static WinningDto of(List<Integer> matchStatistics) {
        Map<WinningResult, Integer> winning = new LinkedHashMap<>();
        winning.put(THREE, matchStatistics.get(THREE.index));
        winning.put(FOUR, matchStatistics.get(FOUR.index));
        winning.put(FIVE, matchStatistics.get(FIVE.index));
        winning.put(FIVE_AND_BONUS, matchStatistics.get(FIVE_AND_BONUS.index));
        winning.put(SIX, matchStatistics.get(SIX.index));

        return new WinningDto(winning, 0);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<WinningResult, Integer> getWinningCount() {
        return winningCount;
    }

    public double getPrice() {
        return price;
    }

}
