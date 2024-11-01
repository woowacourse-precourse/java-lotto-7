package lotto.domain;

public class LottoMatchedResult {
    private final int sixLottoMatchedCount;
    private final boolean isMatchedBonusLotto;

    public LottoMatchedResult(int sixLottoMatchedCount, boolean isMatchedBonusLotto) {
        this.isMatchedBonusLotto = isMatchedBonusLotto;
        this.sixLottoMatchedCount = sixLottoMatchedCount;
    }

    public boolean isMatchedBonusLotto() {
        return isMatchedBonusLotto;
    }

    public int getSixLottoMatchedCount() {
        return sixLottoMatchedCount;
    }

}
