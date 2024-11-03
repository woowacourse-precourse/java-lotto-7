package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoGameController;
import lotto.validator.PurchasePriceValidator;
import lotto.validator.WinningNumValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(new InputView(), new OutputView(),
                new PurchasePriceValidator(), new WinningNumValidator());
        lottoGameController.run();

        Console.close();
    }
}
