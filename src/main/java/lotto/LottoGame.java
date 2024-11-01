package lotto;

import lotto.controller.LottoController;
import lotto.util.LottoGenerator;
import lotto.util.NumberGenerate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private final LottoController lottoController;

    public LottoGame() {
        NumberGenerate lottoGenerate = new LottoGenerator();
        this.lottoController = new LottoController(new InputView(), new OutputView(), lottoGenerate);
    }

    public void run() {
        lottoController.run();
    }
}
