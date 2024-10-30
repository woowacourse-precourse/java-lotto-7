package lotto.model;

import java.util.List;

public class LottoHistory {
    private final Lotto winningLotto;
    private final List<Lotto> lottoList;

    public LottoHistory(Lotto winningLotto, List<Lotto> lottoList) {
        this.winningLotto = winningLotto;
        this.lottoList = lottoList;
    }
}
