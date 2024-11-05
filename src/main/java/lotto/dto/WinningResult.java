package lotto.dto;

import java.util.Map;
import lotto.domain.Rank;

public class WinningResult {

    private final Map<Rank, Integer> result;
    private final long prize;
    private final double rateOfReturn;

    public WinningResult(Map<Rank, Integer> result, long prize, double rateOfReturn) {
        this.result = result;
        this.prize = prize;
        this.rateOfReturn = rateOfReturn;
    }

    public static WinningResult of(Map<Rank, Integer> result, long prize, double rateOfReturn) {
        return new WinningResult(result, prize, rateOfReturn);
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public long getPrize() {
        return prize;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
