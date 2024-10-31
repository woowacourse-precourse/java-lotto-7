package lotto.controller;

import lotto.domain.LottoFormatter;
import lotto.domain.Lottos;
import lotto.dto.LottoBuyResponse;
import lotto.dto.LottoRequest;
import lotto.dto.LottoWinResult;
import lotto.enums.LottoCriteria;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService){
        this.lottoService = lottoService;
    }

    public LottoBuyResponse buyLottos(LottoRequest lottoRequest) {
        StringBuilder responseStringBuilder = new StringBuilder();
        Lottos lottos = lottoService.buyLottos(lottoRequest);
        responseStringBuilder.append(LottoFormatter.getFormattedLottosSize(lottoRequest.buyMoney()));
        responseStringBuilder.append(LottoFormatter.getFormattedLottos(lottos));
        String buyLottoHistory = responseStringBuilder.toString();
        return new LottoBuyResponse(buyLottoHistory,lottos);
    }

    public String calLottos(LottoRequest lottoRequest,Lottos lottos){
        StringBuilder responseStringBuilder = new StringBuilder();
        responseStringBuilder.append(lottoService.calLottoResult(lottos,lottoRequest));
        return responseStringBuilder.toString();
    }
}
