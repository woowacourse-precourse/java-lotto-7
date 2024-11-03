package lotto;

import java.util.List;
import java.util.Map;

public class LottoController {
    public void run() {
        int amount = InputView.inputPurchaseAmount();
        Lottos lottos = new Lottos();
        lottos.issueByAmount(amount);
        OutputView.printPurchasedLottos(lottos);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
    }
}
