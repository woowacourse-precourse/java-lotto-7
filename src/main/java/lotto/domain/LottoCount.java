package lotto.domain;

import lotto.constant.Constant;

public class LottoCount {
    private final int lottoCount;

    private LottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public static LottoCount from(Amount amount) {
        int lottoCount = calculateCount(amount.getAmount());
        return new LottoCount(lottoCount);
    }

    private static int calculateCount(int amount) {
        return amount / Constant.AMOUNT_UNIT;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
