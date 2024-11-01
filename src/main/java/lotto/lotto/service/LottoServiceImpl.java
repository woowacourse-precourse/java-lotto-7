package lotto.lotto.service;

import java.util.List;
import lotto.lotto.controller.port.LottoService;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoResult;
import lotto.lotto.domain.LottoResults;
import lotto.lotto.domain.LottoWinning;

public class LottoServiceImpl implements LottoService {

    private final LottoFactory lottoFactory;
    private final LottoRankCalculator lottoRankCalculator;

    public LottoServiceImpl(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
        this.lottoRankCalculator = new LottoRankCalculator();
    }

    @Override
    public LottoResults createLottos(long count) {
        List<LottoResult> lottoResults = lottoFactory.generateMultipleLottos(count);
        return new LottoResults(lottoResults);
    }

    @Override
    public LottoWinning createWinningLotto(List<Integer> numbers, int bonusNumber) {
        return new LottoWinning(new Lotto(numbers), bonusNumber);
    }

    @Override
    public LottoResults updateLottoRanks(LottoResults lottoResults, LottoWinning lottoWinning) {
        return lottoResults.updateAllLottoRanks(lottoRankCalculator, lottoWinning);
    }
}
