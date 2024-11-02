package lotto.controller;

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
        int lottoPrice = inputView.inputLottoPrice();
        List<String> lottoNum = lottoService.randomLottoNum(lottoPrice);
        outputView.printLottoNum();

        String lottoWinningNumbers = inputView.inputLottoWinningNumbers();
        String lottoBonusNumber = inputView.inputLottoBonusNumber();
        lottoService.winningLotto(lottoWinningNumbers, lottoBonusNumber);

        Map<LottoRank, Integer> lottoResult = lottoService.resultWinningLotto();
        int rate = lottoService.resultRate();

        outputView(lottoResult, rate);
    }
}
