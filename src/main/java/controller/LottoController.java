package controller;

import model.Lotto;
import model.Rank;
import service.LottoService;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static LottoService lottoService = new LottoService();


    public void run(){
        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        int purchaseAmount = lottoService.purchaseAmount(inputPurchaseAmount);
        int count = purchaseAmount /1000;

        List<Lotto> lottoList = lottoService.publishLotto(count);
        outputView.publishLotto(count, lottoList);

        String winningNumber = inputView.inputWinningNumber();
        Lotto lotto = lottoService.inputWinningNumber(winningNumber);

        int bonusNumber = lottoService.bonusNumber(inputView.inputBonusNumber(), lotto);

        Map<Rank, Integer> rankCount = lottoService.calculateStatistics(lottoList, lotto, bonusNumber);
        outputView.printStatistics(rankCount);

        double rate = lottoService.totalReturn(rankCount, purchaseAmount);
        outputView.printTotalReturn(rate);
    }
}
