package lotto.domain.lotto.presentation;

import lotto.domain.lotto.dto.request.LottoGameReq;
import lotto.domain.lotto.dto.response.LottoGameRes;
import lotto.domain.lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void createAndPlayGame(LottoGameReq request) {
        lottoService.createAndPlayGame(request);
    }

    public LottoGameRes getGameResult() {
        return lottoService.getGameResult();
    }

}
