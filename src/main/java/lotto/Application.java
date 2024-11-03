package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = InputView.getInstance();
        System.out.println(inputView.enterPaymentForLottery());
        System.out.println("result: " + inputView.enterWinningLottery());
        System.out.println(inputView.enterBonusLottery());
        LottoController lottoController = new LottoController();

    }
}
