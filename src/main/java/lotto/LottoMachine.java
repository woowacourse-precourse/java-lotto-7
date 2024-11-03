package lotto;

import java.util.List;
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
        System.out.println();

        LottoGenerator lottoGenerator = new LottoGenerator();

        for (int i = 0; i < purchaseCost / 1000; i++) {
            Lotto lotto = new Lotto(lottoGenerator.generateLottoNumbers(1, 45, 6));
            outputHandler.showNumber(lotto);
        }

        outputHandler.showWinningLottoInputComment();
        List<Integer> winningLottoNumber = inputHandler.getWinningLottoInput();
        outputHandler.showWinningLottoBonusNumberInputComment();
        Integer bonusNum = inputHandler.getWinningLottoBonusNumberInput();

        WinningLotto winningLotto = new WinningLotto(winningLottoNumber,bonusNum);


    }
}

