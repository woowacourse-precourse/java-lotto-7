package lotto;

import static lotto.controller.LottoController.getSummary;
import static lotto.model.lottoDraw.drawAndSetLottos;
import static lotto.view.output.printBoughtLottos;

import lotto.controller.LottoController;
import lotto.model.WinningLotto;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.setTotalCount();
        drawAndSetLottos(lottoController);
        printBoughtLottos(lottoController);

        WinningLotto winningLotto = lottoController.makeWinningLotto();
        lottoController.bonusNumber(winningLotto);
        getSummary(lottoController, winningLotto);
    }
}
