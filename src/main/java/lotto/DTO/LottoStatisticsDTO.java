package lotto.DTO;

public class LottoStatisticsDTO {
    private final int matched3Count;
    private final int matched4Count;
    private final int matched5Count;
    private final int matched5WithBonusCount;
    private final int matched6Count;
    private final double profitRate;

    public LottoStatisticsDTO(int matched3Count, int matched4Count, int matched5Count, int matched5WithBonusCount,
                              int matched6Count, double profitRate) {
        this.matched3Count = matched3Count;
        this.matched4Count = matched4Count;
        this.matched5Count = matched5Count;
        this.matched5WithBonusCount = matched5WithBonusCount;
        this.matched6Count = matched6Count;
        this.profitRate = profitRate;
    }

    public int getMatched3Count() {
        return matched3Count;
    }

    public int getMatched4Count() {
        return matched4Count;
    }

    public int getMatched5Count() {
        return matched5Count;
    }

    public int getMatched5WithBonusCount() {
        return matched5WithBonusCount;
    }

    public int getMatched6Count() {
        return matched6Count;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
