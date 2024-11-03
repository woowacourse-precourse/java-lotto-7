package lotto.controller;

import lotto.domain.LottoFormatter;
import lotto.domain.Lottos;
import lotto.dto.LottoBuyRequest;
import lotto.dto.LottoBuyResponse;
import lotto.dto.LottoCalculateRequest;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService){
        this.lottoService = lottoService;
    }

    public LottoBuyResponse buyLottos(LottoBuyRequest lottoRequest) {
        StringBuilder responseStringBuilder = new StringBuilder();
        Lottos lottos = lottoService.buyLottos(lottoRequest);
        responseStringBuilder.append(LottoFormatter.getFormattedLottosSize(lottoRequest.buyMoney()));
        responseStringBuilder.append(LottoFormatter.getFormattedLottos(lottos));
        String buyLottoHistory = responseStringBuilder.toString();
        return new LottoBuyResponse(buyLottoHistory,lottos);
    }

    public String calLottos(LottoCalculateRequest lottoCalculateRequest, Lottos lottos){
        StringBuilder responseStringBuilder = new StringBuilder();
        responseStringBuilder.append(lottoService.calculateLottoResult(lottos, lottoCalculateRequest));
        return responseStringBuilder.toString();
    }
}
