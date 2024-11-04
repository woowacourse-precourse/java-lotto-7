package lotto.service;

import lotto.model.*;

import java.util.List;
import java.util.Map;

public class LottoService {
    private final LottoFactory lottoFactory;
    private final LottoResultCalculator resultCalculator;
    private final ProfitCalculator profitCalculator;

    public LottoService(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
        this.resultCalculator = new LottoResultCalculator();
        this.profitCalculator = new ProfitCalculator();
    }

    public List<Lotto> createLottos(Money money) {
        List<Lotto> lottos = lottoFactory.createLottos(money);
        validateLottos(lottos);
        return lottos;
    }

    public LottoResult calculateResult(List<Lotto> lottos, WinningInfo winningInfo) {
        Map<Rank, Integer> rankCounts = resultCalculator.calculateResults(
                lottos, winningInfo.getWinningNumbers(), winningInfo.getBonusNumber());
        return new LottoResult(rankCounts);
    }

    private void validateLottos(List<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalStateException("로또 생성에 실패했습니다.");
        }
    }
}
