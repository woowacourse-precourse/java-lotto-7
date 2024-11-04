package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    final InputView inputView;
    final OutputView outputView;
    final LottoService lottoService;

    public LottoController(){
        inputView = new InputView();
        outputView = new OutputView();
        lottoService = new LottoService();
    }

    public void run(){
        try{
            int purchaseAmount = inputView.inputPurchaseAmount();

            List<Lotto> purchasedLottos = lottoService.purchaseLotto(purchaseAmount);
            outputView.printPurchasedLottos(purchasedLottos);

            List<Integer> winningLottoNumbers = inputView.inputWinningNumber();
            int bonusNumber = inputView.inputBonusNumber();

            Map<Rank,Integer> result = lottoService.calculateResult(purchasedLottos, winningLottoNumbers, bonusNumber);
            double profitRate = lottoService.calculateProfitRate(result ,purchaseAmount);
            outputView.printResult(result, profitRate);

        } catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }

}
