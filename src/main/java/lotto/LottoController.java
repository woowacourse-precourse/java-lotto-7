package lotto;

import lotto.dto.LottoRequest;
import lotto.dto.LottoResponse;

public class LottoController {

    LottoView lottoView;
    LottoModel lottoModel;

    LottoController(LottoView lottoView, LottoModel lottoModel) {
        this.lottoView = lottoView;
        this.lottoModel = lottoModel;
    }

    public void run() {
        LottoRequest lottoRequest = lottoView.readInput();
        LottoResponse lottoResponse = lottoModel.matchMaking(lottoRequest);
        lottoView.printResult(lottoResponse);
    }
}
