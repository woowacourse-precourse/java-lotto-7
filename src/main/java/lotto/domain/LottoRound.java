package lotto.domain;

import java.util.List;

public class LottoRound {

    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;

    public LottoRound(final List<Lotto> lottos, final WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public LottoResult play() {
        return new LottoResult(lottos, winningLotto);
    }
}
