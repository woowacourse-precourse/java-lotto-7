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
        winning.put(THREE, numbers[3]);
        winning.put(FOUR, numbers[4]);
        winning.put(FIVE, numbers[5]);
        winning.put(FIVE_AND_BONUS, numbers[6]);
        winning.put(SIX, numbers[7]);

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
