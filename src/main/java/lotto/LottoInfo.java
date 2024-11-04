package lotto;

import java.util.List;

public class LottoInfo {
    private final Lotto lotto;

    public LottoInfo(final Lotto lotto) {
        this.lotto = lotto;
    }

    public List<LottoNum> lottoNumbers() {
        return lotto.getNumbers();
    }
}
