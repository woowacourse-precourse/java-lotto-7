package lotto.model;

import java.util.List;

public class LottoHistory {
    private final WinningLotto winningLotto;
    private final List<Lotto> boughtLottoList;

    public LottoHistory(WinningLotto winningLotto, List<Lotto> boughtLottoList) {
        this.winningLotto = winningLotto;
        this.boughtLottoList = boughtLottoList;
    }
}
