package lotto.domain;

public class LottoCount {
    private final int count;

    public LottoCount(LottoPrice lottoPrice) {
        this(lottoPrice.cacluateGameCount());
    }

    public LottoCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
