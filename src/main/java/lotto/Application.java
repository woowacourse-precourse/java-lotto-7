package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoGame;
import lotto.model.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new OutputView(),
                new LottoGame(new OutputView(), new WinningLottoNumbers()));
        lottoController.LottoGameStart();
    }
}
