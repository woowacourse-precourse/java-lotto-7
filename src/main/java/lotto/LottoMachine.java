package lotto;

import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.user.User;

public class LottoMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {
        Integer purchaseCost = null;
        while (purchaseCost == null) {
            try {
                outputHandler.showPurchaseCostInputComments();
                purchaseCost = inputHandler.getPurchaseCost();

            } catch (IllegalArgumentException e) {
                outputHandler.showErrorMessage(e.getMessage());
            }
        }

        outputHandler.showPurchaseLottoCount(purchaseCost);
        LottoGenerator lottoGenerator = new LottoGenerator();

        for (int i = 0; i < purchaseCost / 1000; i++) {
            Lotto lotto = new Lotto(lottoGenerator.generateLottoNumbers(1, 45, 6));
            outputHandler.showNumber(lotto);
        }

    }
}

