package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoServiceImpl;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {

        LottoController lottoController = new LottoController(
                new LottoServiceImpl(),
                new LottoView()
        );

        lottoController.sellLotto();
        lottoController.createWinning();
        lottoController.createBonus();
        lottoController.result();
    }
}
