package lotto;

import lotto.controller.PurchaseController;
import lotto.controller.DrawController;
//import lotto.controller.PrizeController;
//import lotto.controller.ResultController;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PurchaseController purchaseController = new PurchaseController();
        purchaseController.run();

        DrawController drawController = new DrawController();
        drawController.run();

//        PrizeController prizeController = new PrizeController();
//        prizeController.getNumbers();
//
//        ResultController resultController = new ResultController();
//        resultController.run();
    }
}
