package lotto;

import java.util.LinkedHashMap;

public class SpyResult extends Result {
    private long totalPrize;

    public SpyResult() {
        super(new LinkedHashMap<>());
        this.totalPrize = 0L;
    }

    public void setTotalPrize(long totalPrize) {
        this.totalPrize = totalPrize;
    }

    @Override
    public long calculateTotalPrize() {
        return this.totalPrize;
    }
}
