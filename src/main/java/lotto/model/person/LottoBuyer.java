package lotto.model.person;

import static lotto.model.person.LottoSeller.LOTTO_UNIT_AMOUNT;

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

    public double checkProfitRate() {
        int originalMoney = calculatePrincipal();
        return resultExtractor.calculateProfitRate(originalMoney);
    }

    private int calculatePrincipal() {
        int totalLottoCount = lottos.calculateLottoCount();
        return LOTTO_UNIT_AMOUNT * totalLottoCount;
    }
}
