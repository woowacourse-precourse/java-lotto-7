package lotto.lotto.service;

import java.util.List;
import lotto.lotto.controller.port.LottoService;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoResult;
import lotto.lotto.domain.LottoResults;
import lotto.lotto.domain.LottoWinning;
import lotto.lotto.service.port.LottoRepository;

public class LottoServiceImpl implements LottoService {

    private final LottoFactory lottoFactory;
    private final LottoRankCalculator lottoRankCalculator;
    private final LottoRepository lottoRepository;

    public LottoServiceImpl(LottoRepository lottoRepository, LottoFactory lottoFactory) {
        this.lottoRepository = lottoRepository;
        this.lottoFactory = lottoFactory;
        this.lottoRankCalculator = new LottoRankCalculator();
    }

    @Override
    public LottoResults createLottos(long count) {
        List<LottoResult> lottoResultList = lottoFactory.generateMultipleLottos(count);
        LottoResults lottoResults = LottoResults.of(lottoResultList);
        lottoRepository.save(lottoResults);
        return lottoResults;
    }

    @Override
    public LottoResults createLottoWinningAndUpdateRank(List<Integer> numbers, int bonusNumber, String lottoResultsId) {
        LottoWinning winningLotto = createWinningLotto(numbers, bonusNumber);
        return updateLottoRanks(lottoResultsId, winningLotto);
    }

    @Override
    public LottoWinning createWinningLotto(List<Integer> numbers, int bonusNumber) {
        return LottoWinning.of(new Lotto(numbers), bonusNumber);
    }

    @Override
    public LottoResults updateLottoRanks(String lottoResultsId, LottoWinning lottoWinning) {
        LottoResults lottoResults = lottoRepository.findById(lottoResultsId);
        LottoResults updatedLottoResults = lottoResults.updateAllLottoRanks(lottoRankCalculator, lottoWinning);
        lottoRepository.save(updatedLottoResults);
        return updatedLottoResults;
    }

    @Override
    public LottoResults getLottoResults(String lottoResultsId) {
        return lottoRepository.findById(lottoResultsId);
    }

}
