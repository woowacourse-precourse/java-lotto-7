package lotto.domain;

public class LottoCount {
    private final long count;

    private LottoCount(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public static LottoCount calculatePurchaseCount(long price) {
        return new LottoCount(price / 1000);
    }
}
