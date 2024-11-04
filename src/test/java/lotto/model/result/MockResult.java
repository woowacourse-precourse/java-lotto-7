package lotto.model.result;

import java.util.LinkedHashMap;

public class MockResult extends Result {
    private long totalPrize;

    public MockResult() {
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
