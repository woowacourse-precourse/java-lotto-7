package lotto.lotto.controller;

import java.util.List;
import lotto.lotto.controller.port.LottoService;
import lotto.lotto.domain.LottoResults;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public LottoResults getLottosInfo(String lottoResultId) {
        return lottoService.getLottoResults(lottoResultId);
    }

    public LottoResults createWinningLotto(String lottoResultId, List<Integer> numbers, int bonusNumber) {
        return lottoService.createLottoWinningAndUpdateRank(numbers, bonusNumber, lottoResultId);
    }
}
