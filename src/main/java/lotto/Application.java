package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        int lottoMoney = InputView.getLottoMoney();
        LottoController controller = new LottoController(lottoMoney);
        controller.startLotto();
    }
}
