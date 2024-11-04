package lotto.controller;

import lotto.view.InputController;
import lotto.view.OutputController;

public class MainController {
    public static void run() {
        OutputController.purchasePrint();
        InputController.purchaseInput();
        OutputController.lottoAmountPrint();
        LottoController.buyLottoNums();

        OutputController.winningNumPrint();
        LottoController.inputWinningNums();
        OutputController.bonusNumPrint();
        LottoController.inputBonusNums();
    }
}
