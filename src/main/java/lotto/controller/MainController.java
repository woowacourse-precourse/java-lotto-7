package lotto.controller;

import lotto.view.InputController;
import lotto.view.OutputController;

public class MainController {
    public static void run() {
        OutputController.purchasePrint();
        InputController.purchaseInput();
        OutputController.lottoAmountPrint();
    }
}
