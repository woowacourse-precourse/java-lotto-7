package lotto.dto;

import java.util.HashMap;
import lotto.model.Rank;

public class WinningStatistics {

    private final HashMap<Rank, Integer> lottoResult;
    private final double earningRate;

    public WinningStatistics(HashMap<Rank, Integer> lottoResult, double earningRate) {
        this.lottoResult = lottoResult;
        this.earningRate = earningRate;
    }

    public HashMap<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

    public double getEarningRate() {
        return earningRate;
    }
}
