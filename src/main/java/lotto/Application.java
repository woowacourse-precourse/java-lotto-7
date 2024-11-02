package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoGameController;
import lotto.validator.PurchasePriceValidator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(new InputView(),
                new PurchasePriceValidator());
        lottoGameController.run();

        Console.close();
    }
}
