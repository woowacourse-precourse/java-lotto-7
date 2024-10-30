package lotto.controller;

import lotto.domain.Lottos;
import lotto.dto.LottoRequest;
import lotto.dto.LottoWinResult;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService){
        this.lottoService = lottoService;
    }

    public LottoWinResult buyLottos(LottoRequest lottoRequest) {
        Lottos lottos = lottoService.buyLottos(lottoRequest);
        return lottoService.calLottoResult(lottos,lottoRequest);
    }
}
