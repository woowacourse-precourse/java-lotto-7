package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    LottoService lottoService;
    InputView inputView;
    OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Lotto> lotteryTickets =  generateLotteryTickets();
        outputView.printPurchaseLotteryTickets(lotteryTickets);
        WinningLotto winningLotto = createWinningLotto();
        LottoResult result = lottoService.calculateWinningResult(lotteryTickets, winningLotto);
        outputView.printWinningStatistics(result);
    }


    private List<Lotto> generateLotteryTickets() {
        int purchaseAmount = inputView.readPurchaseAmount();
        return lottoService.generateLotteryTickets(purchaseAmount);
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumber = inputView.readWinningNumbers();
        int bonusNumber =  inputView.readBonusNumber(winningNumber);
        return new WinningLotto(winningNumber, bonusNumber);
    }
}