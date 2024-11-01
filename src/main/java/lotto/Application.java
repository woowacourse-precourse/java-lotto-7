package lotto;

import lotto.handlers.InputHandler;
import lotto.handlers.LottoHandler;
import lotto.models.Lottos;
import lotto.ui.InputView;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler(new InputView(), new LottoHandler());

        String purchaseInput = inputHandler.handlePurchaseAmountInput();
        String lottoNumbers = inputHandler.handleLottoNumberInput();
        String bonusNumber = inputHandler.handleBonusNumberInput();

        int purchaseAmount = Integer.parseInt(purchaseInput);
        Lottos lottos = new Lottos(purchaseAmount);
        lottos.generateLottos();

        lottos.getResults(lottoNumbers, bonusNumber);
        lottos.getProfit(purchaseAmount);
    }
}
