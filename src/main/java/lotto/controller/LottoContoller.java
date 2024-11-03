package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.InputView;

public class LottoContoller {
    private LottoService lottoService;
    private InputView inputView;

    private LottoContoller(LottoService lottoService, InputView inputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
    }

    private static class Holder {
        private static final LottoContoller INSTANCE = new LottoContoller(
                LottoServiceImpl.getInstance(),
                InputView.getInstance()
        );
    }

    public static LottoContoller getInstance() {
        return Holder.INSTANCE;
    }

    public void run() {
        lottoService.computeProfitRate(
                inputView.inputPurchaseAmount(),
                inputView.inputWinningNumbers(),
                ""
        );
    }
}
