package lotto;

import lotto.controller.LottoController;
import lotto.factory.LottoFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController controller = LottoFactory.createLottoController();
        controller.startPurchaseAmountInput();
        controller.printNumberOfPurchaseLotto();
        controller.generateLottosByRandomNumber();
        controller.printLottoNumbers();
    }
}
