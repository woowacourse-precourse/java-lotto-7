package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoMachine lottoMachine = new LottoMachine();

        ResultView.displayRequestPurchaseAmount();
        int purchaseAmount = inputView.inputPurchaseAmount();
        ResultView.displayPurchasedLottoCount(purchaseAmount/1000);

        lottoMachine.generateLottos(purchaseAmount);
        List<Lotto> myLottos = lottoMachine.getMyLottos();
        ResultView.displayMyLottos(myLottos);

        ResultView.displayRequestWinningNumbers();
        List<Integer> winningNumbers = inputView.inputWinningNumbers();

        ResultView.displayRequestBonusNumber();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);

        List<Prize> results = lottoMachine.calculateStatistics(myLottos, winningNumbers, bonusNumber);
        ResultView.displayStatistics(results);

        double profitRate = lottoMachine.calculateProfitRate(results, purchaseAmount);
        ResultView.displayProfitRate(profitRate);
    }
}
