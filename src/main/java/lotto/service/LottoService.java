package lotto.service;

import lotto.domain.model.LottoResult;
import lotto.domain.result.LottoStat;
import lotto.domain.model.Lottos;
import lotto.domain.result.WinningLotto;
import lotto.factory.LottoFactory;
import lotto.factory.WinningLottoFactory;

public class LottoService {
    private final LottoFactory lottoFactory;
    private final WinningLottoFactory winningLottoFactory;
    private final LottoCalculator lottoCalculator;

    public LottoService(LottoFactory lottoFactory, WinningLottoFactory winningLottoFactory, LottoCalculator lottoCalculator) {
        this.lottoFactory = lottoFactory;
        this.winningLottoFactory = winningLottoFactory;
        this.lottoCalculator = lottoCalculator;
    }

    public Lottos purchaseLottos(int money) {
        return lottoFactory.createLottos(money);
    }

    public WinningLotto createWinningLotto(String winningNumbers, String bonusNumber) {
        return winningLottoFactory.create(winningNumbers, bonusNumber);
    }

    public LottoResult checkLottoResult(Lottos lottos, WinningLotto winningLotto) {
        LottoStat lottoStat = lottoCalculator.calculateStats(lottos, winningLotto);
        double prizeRate = lottoCalculator.calculatePrizeRate(lottoStat, lottos.getLottos().size());
        return new LottoResult(lottoStat, prizeRate);
    }
}
