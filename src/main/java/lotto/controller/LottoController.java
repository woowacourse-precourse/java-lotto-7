package lotto.controller;

import lotto.dto.request.EarningRateRequest;
import lotto.dto.request.LottoAmountRequest;
import lotto.dto.request.LottoResultRequest;
import lotto.dto.response.EarningRateResponse;
import lotto.dto.response.LottoResultResponse;
import lotto.dto.response.LottoesResponse;
import lotto.service.LottoService;
import lotto.util.Container;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = Container.getInstance(LottoService.class);
    }

    public LottoesResponse makeLottoes(LottoAmountRequest request) {
        return lottoService.makeLottoes(request);
    }

    public LottoResultResponse getLottoResult(LottoResultRequest request) {
        return lottoService.getLottoResult(request);
    }

    public EarningRateResponse getEarningRate(EarningRateRequest request) {
        return lottoService.getEarningRate(request);
    }
}