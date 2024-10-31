package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            LottoMachine lottoMachine = new LottoMachine();

            int purchaseAmount = inputView.inputPurchaseAmount();
            List<Lotto> purchasedLottos = lottoMachine.purchase(purchaseAmount);

            outputView.outputPurchaseAmount(purchasedLottos.size());
            outputView.printLottos(purchasedLottos);

            List<Integer> winningNumbers = inputView.inputWinningNumber();
            int bonusNumber = inputView.inputBonusNumber();

            LottoResult lottoResult = new LottoResult(purchaseAmount);
            Lotto winningLotto = new Lotto(winningNumbers);

            for (Lotto lotto : purchasedLottos) {
                lottoResult.addWinningResult(lotto, winningLotto, bonusNumber);
            }

            outputView.printWinningResult(lottoResult);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}