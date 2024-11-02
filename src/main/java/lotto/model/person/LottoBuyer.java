package lotto.model.person;

import java.util.Map;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.WinningLotto;
import lotto.model.result.Rank;
import lotto.model.result.ResultExtractor;

public class LottoBuyer {
    private Lottos lottos;
    private ResultExtractor resultExtractor;

    public void buyLotto(final int money, final LottoSeller lottoSeller) {
        this.lottos = lottoSeller.sellTo(money);
    }

    public int getLottoCount() {
        return lottos.calculateLottoCount();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Map<Rank, Integer> checkWinningDegree(final WinningLotto winningLotto) {
        resultExtractor = new ResultExtractor(winningLotto, lottos);
        return resultExtractor.extract();
    }
}
