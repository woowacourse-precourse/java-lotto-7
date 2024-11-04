package lotto.lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.lotto.controller.port.LottoService;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoResult;
import lotto.lotto.domain.LottoResults;
import lotto.lotto.domain.LottoWinning;

public class MockLottoService implements LottoService {
    @Override
    public LottoResults createLottos(long count) {
        List<LottoResult> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            results.add(LottoResult.create(lotto));
        }
        return LottoResults.of(results);
    }

    @Override
    public LottoWinning createWinningLotto(List<Integer> numbers, int bonusNumber) {
        Lotto lotto = new Lotto(numbers);
        return LottoWinning.of(lotto, bonusNumber);
    }

    @Override
    public LottoResults updateLottoRanks(String lottoResultsId, LottoWinning lottoWinning) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = LottoResult.create(lotto);
        List<LottoResult> results = new ArrayList<>(List.of(lottoResult));

        LottoWinning winningLotto = createWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        return LottoResults.of(results).updateAllLottoRanks(new LottoRankCalculator(), winningLotto);
    }

    @Override
    public LottoResults getLottoResults(String lottoResultsId) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = LottoResult.create(lotto);
        List<LottoResult> results = new ArrayList<>(List.of(lottoResult));

        return LottoResults.of(results);
    }

    @Override
    public LottoResults createLottoWinningAndUpdateRank(List<Integer> numbers, int bonusNumber, String lottoResultsId) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = LottoResult.create(lotto);
        List<LottoResult> results = new ArrayList<>(List.of(lottoResult));

        LottoWinning winningLotto = createWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        return LottoResults.of(results).updateAllLottoRanks(new LottoRankCalculator(), winningLotto);

    }
}
