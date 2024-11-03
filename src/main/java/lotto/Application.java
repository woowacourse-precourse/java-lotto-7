package lotto;

import lotto.controller.LottoMachine;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        List<Lotto> purchasedLottos = LottoMachine.purchaseLottos(purchaseAmount);

        OutputView.printPurchasedLottos(purchasedLottos);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(winningNumbers);

        LottoResult lottoResult = LottoMachine.getResult(purchasedLottos, winningNumbers, bonusNumber);
        OutputView.printResult(lottoResult, purchaseAmount);
    }
}
