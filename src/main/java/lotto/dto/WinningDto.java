package lotto.dto;

import static lotto.eunm.WinningResult.*;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.eunm.WinningResult;

public class WinningDto {

    private final Map<WinningResult, Integer> winningCount;
    private double price;

    private WinningDto(Map<WinningResult, Integer> winningCount, double price) {
        this.winningCount = winningCount;
        this.price = price;
    }

    public static WinningDto of(int[] numbers) {
        Map<WinningResult, Integer> winning = new LinkedHashMap<>();
        winning.put(THREE, numbers[THREE.winningCount]);
        winning.put(FOUR, numbers[FOUR.winningCount]);
        winning.put(FIVE, numbers[FIVE.winningCount]);
        winning.put(FIVE_AND_BONUS, numbers[FIVE_AND_BONUS.winningCount]);
        winning.put(SIX, numbers[SIX.winningCount]);

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
