package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private LottoService lottoService;
    private InputView inputView;
    private OutputView outputView;

    public LottoController() {
        lottoService = new LottoService();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(){
        String lottoPrice = inputView.inputLottoPrice();
        int lottoPriceInt = lottoService.validateLottoPrice(lottoPrice);

        int lottoNum = lottoService.purchaseLotto(lottoPriceInt);
        List<Lotto> lotto = lottoService.randomLottoNum(lottoNum);
        outputView.printLotto(lotto, lottoNum);

        String lottoWinningNumbers = inputView.inputLottoWinningNumbers();
        String lottoBonusNumber = inputView.inputLottoBonusNumber();
        lottoService.winningLotto(lottoWinningNumbers, lottoBonusNumber);

        Map<LottoRank, Integer> lottoResult = lottoService.resultWinningLotto();
        int rate = lottoService.resultRate();

        outputView(lottoResult, rate);
    }
}
